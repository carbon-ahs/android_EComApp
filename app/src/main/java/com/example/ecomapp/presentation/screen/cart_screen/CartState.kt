package com.example.ecomapp.presentation.screen.cart_screen

import com.example.ecomapp.data.local.entity.Product



/**
 * Created by Ahsan Habib on 5/27/2024.
 */
data class CartState(
    val cartItemList: List<Product> = emptyList()
)
