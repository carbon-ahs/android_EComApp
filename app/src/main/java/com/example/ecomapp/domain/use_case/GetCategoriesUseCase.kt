package com.example.ecomapp.domain.use_case

import android.util.Log
import com.example.ecomapp.core.Resource
import com.example.ecomapp.domain.model.Category
import com.example.ecomapp.domain.repository.EComSiteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject


/**
 * Created by Ahsan Habib on 5/27/2024.
 */
class GetCategoriesUseCase @Inject constructor(
    private val repository: EComSiteRepository
) {
    operator fun invoke(): Flow<Resource<List<Category>>> = flow {
        try {
            emit(Resource.Loading())
            val categories = repository.getCategories() //.map {  }
            emit(Resource.Success(categories))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error!!"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}