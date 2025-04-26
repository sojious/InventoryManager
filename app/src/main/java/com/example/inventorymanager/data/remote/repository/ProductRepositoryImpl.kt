package com.example.inventorymanager.data.remote.repository

import com.example.inventorymanager.data.local.InventoryDatabase
import com.example.inventorymanager.data.local.ProductEntity
import com.example.inventorymanager.data.local.RecentActivityEntity
import com.example.inventorymanager.data.remote.InventoryService
import com.example.inventorymanager.domain.model.Product
import com.example.inventorymanager.domain.model.RecentActivity
import com.example.inventorymanager.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val inventoryDatabase: InventoryDatabase,
    val inventoryService: InventoryService
): ProductRepository {


    override suspend fun getProductsFromApi(): Flow<List<Product>> {
        return flow {
            emit(inventoryService.getProducts().body()!!)
        }
    }

    override suspend fun getProductsFromDb(): Flow<List<ProductEntity>> {
        return inventoryDatabase.productDao().getAllProducts()
    }

    override suspend fun getRecentActivitiesFromApi(): Flow<List<RecentActivity>> {

        return flow{
            emit(inventoryService.getActivities().body()!!)
        }

    }

    override suspend fun getRecentActivitiesFromDb(): Flow<List<RecentActivityEntity>> {
        return inventoryDatabase.ActivityDao().getAllRecentActivities()

    }

    override suspend fun deleteProduct(productId: Int) {
        inventoryDatabase.productDao().deleteProduct(productId)
    }

    override suspend fun insertProductsToDb(products: List<ProductEntity>) {
        inventoryDatabase.productDao().insertProducts(products)
    }

    override suspend fun insertProductToDb(product: ProductEntity) {
        inventoryDatabase.productDao().insertProduct(product)
    }

    override suspend fun insertRecentActivitiesToDb(recentActivities: List<RecentActivityEntity>) {
        inventoryDatabase.ActivityDao().insertRecentActivities(recentActivities)
    }

    override suspend fun insertRecentActivityToDb(recentActivity: RecentActivityEntity) {
        inventoryDatabase.ActivityDao().insertRecentActivity(recentActivity)
    }

    override suspend fun deleteProductFromDb(productId: Int) {
        TODO("Not yet implemented")
    }


}





