package com.example.ecomapp.presentation.screen.cart_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecomapp.data.local.entity.Product
import com.example.ecomapp.domain.use_case.CartItemUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/29/2024.
 */

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartItemUseCases: CartItemUseCases
) : ViewModel() {
    private val _state = mutableStateOf(CartState())
    val state: State<CartState> = _state
    private var getProductsJob: Job? = null

    init {
        getCartItems()
    }

    fun onDeleteClick(product: Product) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                cartItemUseCases.deleteCartItem(product)
            }
        }
    }

    private fun getCartItems() {
        getProductsJob?.cancel()
        getProductsJob = cartItemUseCases.getCartItems()
            .onEach { cartItem ->
                _state.value = state.value.copy(
                    cartItemList = cartItem
                )
            }.launchIn(viewModelScope)
    }
}