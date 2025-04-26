package com.example.inventorymanager.domain.repository

import com.example.inventorymanager.data.local.ProductEntity
import com.example.inventorymanager.data.local.RecentActivityEntity
import com.example.inventorymanager.domain.model.Product
import com.example.inventorymanager.domain.model.RecentActivity
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun getProductsFromApi(): Flow<List<Product>>
    suspend fun getProductsFromDb(): Flow<List<ProductEntity>>
    suspend fun getRecentActivitiesFromApi(): Flow<List<RecentActivity>>
    suspend fun getRecentActivitiesFromDb(): Flow<List<RecentActivityEntity>>
    suspend fun deleteProduct(productId: Int)
    suspend fun insertProductsToDb(products: List<ProductEntity>)
    suspend fun insertProductToDb(product: ProductEntity)
    suspend fun insertRecentActivitiesToDb(recentActivities: List<RecentActivityEntity>)
    suspend fun insertRecentActivityToDb(recentActivity: RecentActivityEntity)
    suspend fun deleteProductFromDb(productId: Int)
}



fun ProductEntity.toProduct(): Product {
    return Product(
        id = id,
        name = name,
        description = description,
        price = price,
        quantity = quantity,
        lastUpdated = lastUpdate,
        category = category,
        imageUrl = imageUrl,
        supplier = supplier,
    )
}

fun RecentActivityEntity.toRecentActivity(): RecentActivity {
    return RecentActivity(
        id = id,
        type = type,
        description = description,
        timestamp = timestamp
    )
}

fun Product.toProductEntity(): ProductEntity {
    return ProductEntity(
        id = id,
        name = name,
        description = description,
        price = price,
        quantity = quantity,
        lastUpdate = lastUpdated,
        category = category,
        imageUrl = imageUrl,
        supplier = supplier,
    )
}

fun RecentActivity.toRecentActivityEntity(): RecentActivityEntity {
    return RecentActivityEntity(
        id = id,
        type = type,
        description = description,
        timestamp = timestamp
    )
}

