package io.jyryuitpro.shoppi.android.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.jyryuitpro.shoppi.android.AssetLoader
import io.jyryuitpro.shoppi.android.ServiceLocator
import io.jyryuitpro.shoppi.android.network.ApiClient
import io.jyryuitpro.shoppi.android.repository.category.CategoryRemoteDataSource
import io.jyryuitpro.shoppi.android.repository.category.CategoryRepository
import io.jyryuitpro.shoppi.android.repository.categorydetail.CategoryDetailRemoteDataSource
import io.jyryuitpro.shoppi.android.repository.categorydetail.CategoryDetailRepository
import io.jyryuitpro.shoppi.android.repository.home.HomeAssetDataSource
import io.jyryuitpro.shoppi.android.repository.home.HomeRepository
import io.jyryuitpro.shoppi.android.repository.productdetail.ProductDetailRemoteDataSource
import io.jyryuitpro.shoppi.android.repository.productdetail.ProductDetailRepository
import io.jyryuitpro.shoppi.android.ui.cart.CartViewModel
import io.jyryuitpro.shoppi.android.ui.category.CategoryViewModel
import io.jyryuitpro.shoppi.android.ui.categorydetail.CategoryDetailViewModel
import io.jyryuitpro.shoppi.android.ui.home.HomeViewModel
import io.jyryuitpro.shoppi.android.ui.productdetail.ProductDetailViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // HomeViewModel 타입 검사
        return when {
            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
                // TODO DI Hilt
                val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
                HomeViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryViewModel::class.java) -> {
                val repository = CategoryRepository(CategoryRemoteDataSource(ApiClient.create()))
                CategoryViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CategoryDetailViewModel::class.java) -> {
                val repository =
                    CategoryDetailRepository(CategoryDetailRemoteDataSource(ApiClient.create()))
                CategoryDetailViewModel(repository) as T
            }
            modelClass.isAssignableFrom(ProductDetailViewModel::class.java) -> {
                val repository = ProductDetailRepository(
                    ProductDetailRemoteDataSource(
                        ServiceLocator.provideApiClient()
                    )
                )
                ProductDetailViewModel(repository) as T
            }
            modelClass.isAssignableFrom(CartViewModel::class.java) -> {
                CartViewModel(ServiceLocator.provideCartRepository(context)) as T
            }
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}