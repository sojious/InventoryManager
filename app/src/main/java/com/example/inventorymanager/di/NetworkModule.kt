package com.example.inventorymanager.di

import android.content.Context
import com.example.inventorymanager.data.remote.InventoryService
import com.example.inventorymanager.data.remote.MockInterceptor
import com.example.inventorymanager.util.MOCK_SERVER_BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideMockInventoryService(okHttpClient: OkHttpClient): InventoryService =
        Retrofit.Builder()
            .baseUrl(MOCK_SERVER_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(InventoryService::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(mockInterceptor: MockInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(mockInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    fun provideMockInterceptor(@ApplicationContext context: Context): MockInterceptor = MockInterceptor(context)
}