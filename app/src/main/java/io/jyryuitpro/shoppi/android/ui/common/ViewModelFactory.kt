package io.jyryuitpro.shoppi.android.ui.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.jyryuitpro.shoppi.android.AssetLoader
import io.jyryuitpro.shoppi.android.repository.HomeAssetDataSource
import io.jyryuitpro.shoppi.android.repository.HomeRepository
import io.jyryuitpro.shoppi.android.ui.home.HomeViewModel

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            val repository = HomeRepository(HomeAssetDataSource(AssetLoader(context)))
            return HomeViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Failed to create ViewModel: ${modelClass.name}")
        }
    }
}