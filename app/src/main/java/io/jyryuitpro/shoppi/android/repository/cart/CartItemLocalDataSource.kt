package io.jyryuitpro.shoppi.android.repository.cart

import io.jyryuitpro.shoppi.android.database.CartItemDao
import io.jyryuitpro.shoppi.android.model.CartItem


class CartItemLocalDataSource(
    private val dao: CartItemDao
) : CartItemDataSource {

    override suspend fun addCartItem(cartItem: CartItem) {
        dao.insert(cartItem)
    }

    override suspend fun getCartItems(): List<CartItem> {
        return dao.load()
    }
}