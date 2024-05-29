package com.example.ecomapp.domain.use_case

/**
 * Created by Ahsan Habib on 5/29/2024.
 */

data class CartItemUseCases(
    val getCartItems: GetCartItems,
    val deleteCartItem: DeleteCartItem,
    val addCartItem: AddCartItem
)