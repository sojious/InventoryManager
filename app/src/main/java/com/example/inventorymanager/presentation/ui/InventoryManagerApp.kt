package com.example.inventorymanager.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.inventorymanager.presentation.Login
import com.example.inventorymanager.presentation.ui.components.InventoryManagerBottomBar

@Composable
fun InventoryManagerApp(modifier: Modifier = Modifier, navController: NavHostController){

    Scaffold(
      modifier = modifier.fillMaxSize(),
        //topBar ={HeaderSection()},
        bottomBar = {InventoryManagerBottomBar(navController = navController)}

    ){contentPadding ->
        InventoryManagerNavHost(navController = navController, modifier = Modifier.padding(contentPadding))
    }
}

@Composable
fun BottomBar(modifier: Modifier = Modifier){

}
