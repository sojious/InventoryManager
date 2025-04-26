package com.example.inventorymanager.domain.model

data class Product(
    val id: Int,
    val name: String,
    val quantity: Int,
    val price : Double,
    val lastUpdated: String,
    val category: String,
    val imageUrl : String,
    val description: String,
    val supplier: String,

)
