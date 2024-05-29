package com.example.ecomapp.data.remote.api

import com.example.ecomapp.data.remote.dto.CategoryApiDto
import com.example.ecomapp.data.remote.dto.ProductsByCategoryApiDto
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Created by Ahsan Habib on 5/29/2024.
 */
interface EComSiteApi {
    @GET("get-categories")
    suspend fun getCategories() : CategoryApiDto

    @GET("product-by-category/{categoryId}")
    suspend fun getProductsByCategoryId(@Path("categoryId") categoryId: String) : ProductsByCategoryApiDto

    companion object {
        const val BASE_URL = "https://e-unionint.com/api/"
    }
}