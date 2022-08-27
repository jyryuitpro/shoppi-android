package io.jyryuitpro.shoppi.android.repository.category

import io.jyryuitpro.shoppi.android.model.Category

class CategoryRepository(private val remoteDataSource: CategoryRemoteDataSource) {

    suspend fun getCategories(): List<Category> {
//        withContext(Dispatchers.IO) {
//            remoteDataSource.getCategories()
//        }
        return remoteDataSource.getCategories()
    }
}