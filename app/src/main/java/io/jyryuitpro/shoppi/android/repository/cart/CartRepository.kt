package io.jyryuitpro.shoppi.android.repository.cart

import io.jyryuitpro.shoppi.android.model.CartItem
import io.jyryuitpro.shoppi.android.model.Product
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CartRepository(
    private val localDataSource: CartItemLocalDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun addCartItem(product: Product) {
        withContext(ioDispatcher) {
            val cartItem = CartItem(
                productId = product.productId,
                label = product.label,
                price = product.price,
                brandName = product.brandName ?: "",
                thumbnailImageUrl = product.thumbnailImageUrl ?: "",
                type = product.type ?: "",
                amount = 1
            )
            localDataSource.addCartItem(cartItem)
        }
    }

    suspend fun getCartItems(): List<CartItem> {
        return withContext(ioDispatcher) {
            localDataSource.getCartItems()
        }
    }
}