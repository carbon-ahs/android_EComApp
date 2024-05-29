package com.example.ecomapp.presentation.screen.categories_screen

import com.example.ecomapp.domain.model.Category

/**
 * Created by Ahsan Habib on 5/27/2024.
 */

data class CategoriesState(
    val isLoading: Boolean = false,
    val categories: List<Category> = emptyList(),
    val error: String = ""
)
