package com.example.ecomapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Ahsan Habib on 5/27/2024.
 */
@Entity
data class Product(
    @PrimaryKey
    val id: Int,
    val name: String,
    val categoryName: String?
)