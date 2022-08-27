package io.jyryuitpro.shoppi.android.repository.categorydetail

import io.jyryuitpro.shoppi.android.model.CategoryDetail
import io.jyryuitpro.shoppi.android.network.ApiClient

class CategoryDetailRemoteDataSource(private val apiClient: ApiClient) : CategoryDetailDataSource {

    override suspend fun getCategoryDetail(): CategoryDetail {
        return apiClient.getCategoryDetail()
    }
}