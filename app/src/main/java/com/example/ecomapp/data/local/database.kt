package com.example.ecomapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ecomapp.data.local.dao.ProductDao
import com.example.ecomapp.data.local.entity.Product

/**
 * Created by Ahsan Habib on 5/26/2024.
 */
@Database(
    entities = [Product::class],
    version = 1
)
abstract class LocalDatabase : RoomDatabase() {
    abstract val dao: ProductDao

    companion object {
        const val DATABASE_NAME = "EComApp_db"
    }
}