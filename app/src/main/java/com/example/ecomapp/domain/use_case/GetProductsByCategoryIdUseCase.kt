package com.example.ecomapp.domain.use_case

import com.example.ecomapp.core.Resource
import com.example.ecomapp.data.local.entity.Product
import com.example.ecomapp.domain.repository.EComSiteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/29/2024.
 */
class GetProductsByCategoryIdUseCase @Inject constructor(
    private val repository: EComSiteRepository
) {
    operator fun invoke(categoryId: String): Flow<Resource<List<Product>>> = flow {
        try {
            emit(Resource.Loading())
            val products = repository.getProductsByCategoryId(categoryId) //.map {  }
            emit(Resource.Success(products))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error!!"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}