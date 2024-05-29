package com.example.ecomapp.domain.use_case

import com.example.ecomapp.data.local.entity.Product
import com.example.ecomapp.domain.repository.EComSiteRepository
import javax.inject.Inject

class DeleteCartItem @Inject constructor(
    private val repository: EComSiteRepository
) {
    suspend operator fun invoke(product: Product) {
        repository.deleteProduct(product)
    }
}