package com.example.inventorymanager.data.remote

import com.example.inventorymanager.domain.model.RecentActivity
import com.example.inventorymanager.domain.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface InventoryService {

    @GET("products")
    suspend fun getProducts(): Response<List<Product>>

    @GET("activities")
    suspend fun getActivities(): Response<List<RecentActivity>>
}