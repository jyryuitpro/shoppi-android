package io.jyryuitpro.shoppi.android.repository.cart

import io.jyryuitpro.shoppi.android.model.CartItem


interface CartItemDataSource {

    suspend fun addCartItem(cartItem: CartItem)

    suspend fun getCartItems(): List<CartItem>
}