package io.jyryuitpro.shoppi.android.repository

import io.jyryuitpro.shoppi.android.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CategoryRepository(private val remoteDataSource: CategoryRemoteDataSource) {

    suspend fun getCategories(): List<Category> {
//        withContext(Dispatchers.IO) {
//            remoteDataSource.getCategories()
//        }
        return remoteDataSource.getCategories()
    }
}