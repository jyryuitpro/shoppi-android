package io.jyryuitpro.shoppi.android.repository.category

import io.jyryuitpro.shoppi.android.model.Category

interface CategoryDataSource {

    suspend fun getCategories(): List<Category>
}