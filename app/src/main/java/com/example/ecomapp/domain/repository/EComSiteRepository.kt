package com.example.ecomapp.domain.repository


import com.example.ecomapp.data.local.entity.Product
import com.example.ecomapp.domain.model.Category
import kotlinx.coroutines.flow.Flow


/**
 * Created by Ahsan Habib on 5/27/2024.
 */
interface EComSiteRepository {
    suspend fun getCategories(): List<Category>
    suspend fun getProductsByCategoryId(categoryId: String) : List<Product>

    fun getProducts() : Flow<List<Product>>
    suspend fun insertProduct(product: Product)
    suspend fun deleteProduct(product: Product)
}