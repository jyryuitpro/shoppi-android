package io.jyryuitpro.shoppi.android.repository.productdetail

import io.jyryuitpro.shoppi.android.model.Product

class ProductDetailRepository(
    private val remoteDataSource: ProductDetailDataSource
) {

    suspend fun getProductDetail(productId: String): Product {
        return remoteDataSource.getProductDetail(productId)
    }
}