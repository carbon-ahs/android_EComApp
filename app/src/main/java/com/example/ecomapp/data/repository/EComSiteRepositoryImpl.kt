package com.example.ecomapp.data.repository

import com.example.ecomapp.data.local.LocalDatabase
import com.example.ecomapp.data.local.dao.ProductDao
import com.example.ecomapp.data.local.entity.Product
import com.example.ecomapp.data.remote.api.EComSiteApi
import com.example.ecomapp.data.remote.dto.toCategoryList
import com.example.ecomapp.data.remote.dto.toProductList
import com.example.ecomapp.domain.model.Category
import com.example.ecomapp.domain.repository.EComSiteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/29/2024.
 */
class EComSiteRepositoryImpl @Inject constructor(
    private val api: EComSiteApi,
    private val db: LocalDatabase
) : EComSiteRepository {
    override suspend fun getCategories(): List<Category> {
        var apiObj = api.getCategories()
        var categoryList = apiObj.toCategoryList()
        return categoryList
    }

    override suspend fun getProductsByCategoryId(categoryId: String): List<Product> {
        return api.getProductsByCategoryId(categoryId).toProductList()
    }

    override fun getProducts(): Flow<List<Product>> {
        return db.dao.getAllProducts()
    }

    override suspend fun insertProduct(product: Product) {
        db.dao.insertProduct(product)
    }

    override suspend fun deleteProduct(product: Product) {
        db.dao.deleteProduct(product)
    }
}
