package com.example.inventorymanager.di

import android.content.Context
import androidx.room.Room
import com.example.inventorymanager.data.local.InventoryDatabase
import com.example.inventorymanager.data.remote.InventoryService
import com.example.inventorymanager.data.remote.repository.ProductRepositoryImpl
import com.example.inventorymanager.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {


    @Module
    @InstallIn(SingletonComponent::class)
       abstract class RepositoryModule{
           @Binds
            @Singleton
            abstract fun bindProductRepository(productRepositoryImpl: ProductRepositoryImpl): ProductRepository
       }




    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): InventoryDatabase =
        Room.databaseBuilder(context, InventoryDatabase::class.java,"inventory_db")
            .fallbackToDestructiveMigration(false)
            .build()
}