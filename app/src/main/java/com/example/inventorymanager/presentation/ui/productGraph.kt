package com.example.inventorymanager.presentation.ui

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.inventorymanager.presentation.ProductDetail
import com.example.inventorymanager.presentation.ProductGraph
import com.example.inventorymanager.presentation.Products
import com.example.inventorymanager.presentation.ui.Dashboard.DashBoardViewModel
import com.example.inventorymanager.presentation.ui.ProductList.ProductDetailsScreen
import com.example.inventorymanager.presentation.ui.ProductList.ProductListScreen

fun NavGraphBuilder.productGraph(
    dashBoardViewModel: DashBoardViewModel,
    navController: NavHostController
){

    navigation(startDestination = Products.route , route = ProductGraph.route ){
        composable(route= Products.route){
            ProductListScreen(dashBoardViewModel = dashBoardViewModel, navController = navController)
        }

        composable(
            route= ProductDetail.route,
            arguments = ProductDetail.args
        ){
            ProductDetailsScreen()
        }
    }
}
