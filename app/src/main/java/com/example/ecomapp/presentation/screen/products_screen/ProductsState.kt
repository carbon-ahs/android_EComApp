package com.example.ecomapp.presentation.screen.products_screen

import com.example.ecomapp.data.local.entity.Product
/**
 * Created by Ahsan Habib on 5/27/2024.
 */

data class ProductsState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String = ""
)
