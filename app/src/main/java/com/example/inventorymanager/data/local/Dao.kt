package com.example.inventorymanager.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.inventorymanager.domain.model.Product
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    // Summary operations
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: ProductEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<ProductEntity> )

    @Query("SELECT * FROM product WHERE id = :productId")
    suspend fun getProduct(productId: Int): ProductEntity?

    @Query("DELETE FROM product WHERE id = :productId")
    suspend fun deleteProduct(productId: Int)

    @Query("SELECT * FROM product")
    fun getAllProducts(): Flow<List<ProductEntity>>

}


@Dao
interface ActivityDao {

    // Summary operations
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecentActivity(activity: RecentActivityEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecentActivities(activities: List<RecentActivityEntity>)

    @Query("SELECT * FROM recent_activity ORDER BY timestamp DESC")
    fun getAllRecentActivities(): Flow<List<RecentActivityEntity>>

    @Query("DELETE FROM recent_activity WHERE id = :activityId")
    suspend fun deleteRecentActivity(activityId:Int)



}