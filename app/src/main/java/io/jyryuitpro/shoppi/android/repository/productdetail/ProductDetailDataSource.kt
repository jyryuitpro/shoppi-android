package io.jyryuitpro.shoppi.android.repository.productdetail

import io.jyryuitpro.shoppi.android.model.Product

interface ProductDetailDataSource {

    suspend fun getProductDetail(productId: String): Product

}