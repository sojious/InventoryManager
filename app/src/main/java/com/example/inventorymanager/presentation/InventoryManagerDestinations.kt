package com.example.inventorymanager.presentation

import androidx.navigation.NavType
import androidx.navigation.navArgument

/**
 * Interface whose implementations holds navigation specific information
 * for each destination in the app's navigation graph
 */


interface InventoryManagerDestination{
    val route:String
}




object DashBoard:InventoryManagerDestination{
    override val route="dashBoard"
}

object Products:InventoryManagerDestination{
    override val route="products"
}

object AddProduct:InventoryManagerDestination{
    override val route="addProduct"
}

object ProductDetail:InventoryManagerDestination{
    val productIdArg="productId"
    override val route="product/{$productIdArg}"
    val args = listOf(
        navArgument(name = productIdArg) {
            type = NavType.IntType
        }
    )
}

object Login:InventoryManagerDestination{
    override val route="login"
}

object Report:InventoryManagerDestination{
    override val route="report"
}

object ProductGraph:InventoryManagerDestination{

    override val route = "productGraph"
}






