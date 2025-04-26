package com.example.inventorymanager.presentation.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.inventorymanager.R
import com.example.inventorymanager.presentation.DashBoard
import com.example.inventorymanager.presentation.Login
import com.example.inventorymanager.presentation.ProductGraph
import com.example.inventorymanager.presentation.Report
import com.example.inventorymanager.presentation.theme.White
import com.example.inventorymanager.presentation.theme.primaryBlue
import com.example.inventorymanager.presentation.ui.Dashboard.DashBoardViewModel

@Composable
fun InventoryManagerBottomBar(
    modifier: Modifier=Modifier,
    dashBoardViewModel: DashBoardViewModel = hiltViewModel(),
    //currentBackStackEntry: NavBackStackEntry?,
    navController: NavHostController
){

    //val selectedItem = navController.currentDestination
    //val showBottomNav=currentDestination?.route!= Login.route


    val currentBackStackEntry = navController.currentBackStackEntryAsState().value?.destination
    val currentBackStackRoute = currentBackStackEntry?.route

    LaunchedEffect(key1 = Unit) {

    }

    if (currentBackStackRoute!= Login.route){
        NavigationBar(
            modifier=modifier,
            containerColor = White,
            contentColor = primaryBlue,
        ) {


            destinations.forEachIndexed { index, destination ->
                val labelText=when(index){
                    0 ->"Home"
                    1 ->"Products"
                    else ->"Report"
                }

                val iconResId=when(index){
                    0 -> R.drawable.ic_baseline_home
                    1 -> R.drawable.ic_task
                    else -> R.drawable.ic_paddlock
                }


                //val selected= navController.currentDestination?.hierarchy?.any{it.route==destination.route} ==true

                NavigationBarItem(
                    selected =  currentBackStackEntry?.hierarchy?.any { it.route == destination.route } == true,
                    onClick = {
                        dashBoardViewModel.onBottomNavItemClicked(index, navController)
                    },
                    label ={ Text(text = labelText) },
                    alwaysShowLabel = true,
                    icon = { Icon(painter = painterResource(id = iconResId), contentDescription =null ) },
                )
            }

        }
    }



}



val destinations= listOf(DashBoard, ProductGraph, Report)