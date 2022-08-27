package io.jyryuitpro.shoppi.android.repository.categorydetail

import io.jyryuitpro.shoppi.android.model.CategoryDetail

interface CategoryDetailDataSource {

    suspend fun getCategoryDetail(): CategoryDetail
}