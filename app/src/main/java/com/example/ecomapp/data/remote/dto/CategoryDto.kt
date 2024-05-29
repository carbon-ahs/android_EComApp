package com.example.ecomapp.data.remote.dto

import com.example.ecomapp.domain.model.Category
import com.google.gson.annotations.SerializedName

data class CategoryDto(
    @SerializedName("category_name")
    val categoryName: String,
    val id: Int
)

fun CategoryDto.toCategory(): Category {
    return Category(
        id = id,
        name = categoryName
    )
}