package io.jyryuitpro.shoppi.android.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.jyryuitpro.shoppi.android.model.CartItem

@Dao
interface CartItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cartItem: CartItem)

    @Query("SELECT * FROM cart_item")
    suspend fun load(): List<CartItem>
}