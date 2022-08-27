package io.jyryuitpro.shoppi.android.repository

import io.jyryuitpro.shoppi.android.model.Category

interface CategoryDataSource {

    suspend fun getCategories(): List<Category>
}