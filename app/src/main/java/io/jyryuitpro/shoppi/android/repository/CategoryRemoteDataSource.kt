package io.jyryuitpro.shoppi.android.repository

import io.jyryuitpro.shoppi.android.model.Category
import io.jyryuitpro.shoppi.android.network.ApiClient

class CategoryRemoteDataSource(private val apiClient: ApiClient) : CategoryDataSource {

    override suspend fun getCategories(): List<Category> {
        return apiClient.getCategories()
    }
}