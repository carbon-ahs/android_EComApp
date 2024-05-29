package com.example.ecomapp.presentation.screen.products_screen

import com.example.ecomapp.data.local.entity.Product
import com.example.ecomapp.domain.model.Category



/**
 * Created by Ahsan Habib on 5/27/2024.
 */
data class ProductsState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String = ""
)
