package com.example.ecomapp.domain.use_case

import com.example.ecomapp.core.Resource
import com.example.ecomapp.data.local.entity.Product
import com.example.ecomapp.domain.model.Category
import com.example.ecomapp.domain.repository.EComSiteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetCartItems @Inject constructor(
    private val repository: EComSiteRepository
) {
    suspend operator fun invoke(product: Product) {
        repository.getProducts()
    }
    operator fun invoke(): Flow<List<Product>> {
        return repository.getProducts()
    }
}