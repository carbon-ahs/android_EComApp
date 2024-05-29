package com.example.ecomapp.di

import android.app.Application
import androidx.room.Room
import com.example.ecomapp.data.local.LocalDatabase
import com.example.ecomapp.data.local.dao.ProductDao
import com.example.ecomapp.data.remote.api.EComSiteApi
import com.example.ecomapp.data.repository.EComSiteRepositoryImpl
import com.example.ecomapp.domain.repository.EComSiteRepository
import com.example.ecomapp.domain.use_case.AddCartItem
import com.example.ecomapp.domain.use_case.CartItemUseCases
import com.example.ecomapp.domain.use_case.DeleteCartItem
import com.example.ecomapp.domain.use_case.GetCartItems
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(
        app: Application,
    ): LocalDatabase {
        return Room.databaseBuilder(
            app,
            LocalDatabase::class.java,
            LocalDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideEComSiteApi(): EComSiteApi {
        return Retrofit.Builder()
            .baseUrl(EComSiteApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EComSiteApi::class.java)
    }

    @Provides
    @Singleton
    fun provideEComSiteRepository(
        api: EComSiteApi,
        db: LocalDatabase
    ): EComSiteRepository {
        return EComSiteRepositoryImpl(api, db)
    }


    @Provides
    @Singleton
    fun provideAddItem(
        repository: EComSiteRepository,
    ): AddCartItem {
        return AddCartItem(repository)
    }

    @Provides
    @Singleton
    fun provideCartItemUseCases(
        repository: EComSiteRepository,
    ): CartItemUseCases {
        return CartItemUseCases(
            getCartItems = GetCartItems(repository),
            deleteCartItem = DeleteCartItem(repository),
            addCartItem = AddCartItem(repository)
        )
    }

}