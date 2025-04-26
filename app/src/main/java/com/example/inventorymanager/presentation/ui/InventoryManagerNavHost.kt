package com.example.inventorymanager.presentation.ui

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.inventorymanager.presentation.AddProduct
import com.example.inventorymanager.presentation.DashBoard
import com.example.inventorymanager.presentation.Login
import com.example.inventorymanager.presentation.ProductDetail
import com.example.inventorymanager.presentation.Products
import com.example.inventorymanager.presentation.Report
import com.example.inventorymanager.presentation.ui.Auth.LoginScreen
import com.example.inventorymanager.presentation.ui.Dashboard.DashBoardScreen
import com.example.inventorymanager.presentation.ui.Dashboard.DashBoardViewModel
import com.example.inventorymanager.presentation.ui.ProductList.ProductDetailsScreen
import com.example.inventorymanager.presentation.ui.ProductList.ProductListScreen

@Composable
fun InventoryManagerNavHost(
    modifier: Modifier,
    navController: NavHostController,
){


    //initialize viewmodels
    val dashBoardViewModel: DashBoardViewModel = hiltViewModel()


    val density= LocalDensity.current
    val drawerState= rememberDrawerState(initialValue = DrawerValue.Closed)


    NavHost(
        modifier=modifier,
        navController =navController ,
        startDestination = Login.route
    ){

        composable(route = DashBoard.route){
            DashBoardScreen(dashBoardViewModel)
        }

        composable(route = Login.route){
            LoginScreen(navController = navController)
        }

        productGraph(
            navController = navController,
            dashBoardViewModel = dashBoardViewModel
        )


        composable(route = Report.route){

        }

    }
}