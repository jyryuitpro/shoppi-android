package io.jyryuitpro.shoppi.android.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.jyryuitpro.shoppi.android.AssetLoader
import io.jyryuitpro.shoppi.android.network.ApiClient
import io.jyryuitpro.shoppi.android.repository.CategoryRemoteDataSource
import io.jyryuitpro.shoppi.android.repository.CategoryRepository
import io.jyryuitpro.shoppi.android.repository.HomeAssetDataSource
import io.jyryuitpro.shoppi.android.repository.HomeRepository
import io.jyryuitpro.shoppi.android.ui.category.CategoryViewModel
import io.jyryuitpro.shoppi.android.ui.home.HomeViewModel

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
            else -> {
                throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
            }
        }
    }
}