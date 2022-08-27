package io.jyryuitpro.shoppi.android.repository.productdetail

import io.jyryuitpro.shoppi.android.model.Product
import io.jyryuitpro.shoppi.android.network.ApiClient

class ProductDetailRemoteDataSource(
    private val api: ApiClient
) : ProductDetailDataSource {

    override suspend fun getProductDetail(productId: String): Product {
        return api.getProductDetail(productId)
    }
}