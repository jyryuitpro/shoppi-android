package com.shoppi.app.repository.cart

import com.shoppi.app.database.CartItemDao
import com.shoppi.app.model.CartItem

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