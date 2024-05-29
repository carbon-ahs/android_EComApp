package com.example.ecomapp.domain.use_case

import com.example.ecomapp.data.local.entity.Product
import com.example.ecomapp.domain.repository.EComSiteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCartItems @Inject constructor(
    private val repository: EComSiteRepository
) {
    operator fun invoke(product: Product) {
        repository.getProducts()
    }
    operator fun invoke(): Flow<List<Product>> {
        return repository.getProducts()
    }
}