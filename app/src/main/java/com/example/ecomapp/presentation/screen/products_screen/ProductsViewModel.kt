package com.example.ecomapp.presentation.screen.products_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecomapp.core.Resource
import com.example.ecomapp.data.local.entity.Product
import com.example.ecomapp.domain.use_case.AddCartItem
import com.example.ecomapp.domain.use_case.GetProductsByCategoryIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/29/2024.
 */
@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsByCategoryIdUseCase: GetProductsByCategoryIdUseCase,
    private val savedStateHandle: SavedStateHandle,
    private val addCartItem: AddCartItem

) : ViewModel() {
    private val _state = mutableStateOf(ProductsState())

    val state: State<ProductsState> = _state
    init {
        val categoryId = retrieveCategoryId("categoryId")
        if (categoryId != null) {
            getProductsByCategoryId(categoryId)
        }
    }
    fun getProductsByCategoryId(categoryId : String) {
        getProductsByCategoryIdUseCase.invoke(categoryId).onEach { result ->
            when(result) {
                is Resource.Error -> {
                    _state.value = ProductsState(error = result.message ?: "Error")
                }
                is Resource.Loading -> {
                    _state.value = ProductsState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = ProductsState(products = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }

    fun retrieveCategoryId(key: String): String? {
        return savedStateHandle.get(key)
    }

    fun onAddClick(product: Product) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                addCartItem(product)
            }
        }
    }
}