package io.jyryuitpro.shoppi.android.database

import androidx.room.Database
import androidx.room.RoomDatabase
import io.jyryuitpro.shoppi.android.model.CartItem


@Database(entities = [CartItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao
}