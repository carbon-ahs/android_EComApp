package com.example.ecomapp.data.remote.dto

import com.example.ecomapp.data.local.entity.Product

data class ProductDto(
    val id: Int,
    val product_name: String
)

fun ProductDto.toProduct(): Product {
    return Product(
        id = id,
        name = product_name,
        categoryName = null
    )
}