package com.example.inventorymanager.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recent_activity")
data class RecentActivityEntity(
    @PrimaryKey val id: Int,
    val type: String,
    val description: String,
    val timestamp: String
)



@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val quantity: Int,
    val price : Double,
    val lastUpdate: String,
    val category: String,
    val imageUrl : String,
    val description: String,
    val supplier: String,

    )

