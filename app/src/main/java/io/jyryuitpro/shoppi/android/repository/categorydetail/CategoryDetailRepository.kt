package io.jyryuitpro.shoppi.android.repository.categorydetail

import io.jyryuitpro.shoppi.android.model.CategoryDetail

class CategoryDetailRepository(private val remoteDataSource: CategoryDetailRemoteDataSource) {

    suspend fun getCategoryDetail(): CategoryDetail {
        return remoteDataSource.getCategoryDetail()
    }
}