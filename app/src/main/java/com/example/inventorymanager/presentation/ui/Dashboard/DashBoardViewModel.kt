package com.example.inventorymanager.presentation.ui.Dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.inventorymanager.domain.model.Product
import com.example.inventorymanager.domain.model.RecentActivity
import com.example.inventorymanager.domain.repository.ProductRepository
import com.example.inventorymanager.domain.repository.toProduct
import com.example.inventorymanager.domain.repository.toProductEntity
import com.example.inventorymanager.domain.repository.toRecentActivity
import com.example.inventorymanager.domain.repository.toRecentActivityEntity
import com.example.inventorymanager.presentation.DashBoard
import com.example.inventorymanager.presentation.Products
import com.example.inventorymanager.presentation.Report
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashBoardViewModel @Inject constructor(private val productRepository: ProductRepository): ViewModel() {

    var products = mutableStateListOf<Product>()
        private set
    var recentActivities  = mutableStateListOf<RecentActivity>()
        private set


    var selectedBottomNavBarItem by mutableIntStateOf(0)
        private set

    private val _uiStateFlow = MutableStateFlow(DashBoardScreenUiState())
    val uIStateFlow = _uiStateFlow.asStateFlow()



    fun getProductsFromMockServer() {
        viewModelScope.launch {

            // Get products from a call to mock Api
            productRepository.getProductsFromApi().collect {
                products = it.toMutableStateList()


            }
            // Get activities from mock Api
            productRepository.getRecentActivitiesFromApi().collect {
                recentActivities = it.toMutableStateList()

            }

            // store products in local database
            productRepository.insertProductsToDb(products.map{it.toProductEntity()})

            // store Activities in local database
            productRepository.insertRecentActivitiesToDb(recentActivities.map{it.toRecentActivityEntity()})
        }


    }

    fun getProductsFromLocalDatabase(){

       viewModelScope.launch {
           productRepository.getProductsFromDb().collect {
               it.map { entityProduct ->
                   entityProduct.toProduct()
               }.toMutableStateList().also { products = it }
            }


           productRepository.getRecentActivitiesFromDb().collect {
               it.map{entityRecentActivity->
                   entityRecentActivity.toRecentActivity()
               }.toMutableStateList().also { recentActivities = it }
           }
       }
    }




    fun onBottomNavItemClicked(index: Int, navController: NavHostController) {
        selectedBottomNavBarItem = index
        when(index){
            0 -> navController.navigate (DashBoard.route){ launchSingleTop = true }
            1 -> navController.navigate (Products.route){ launchSingleTop = true }
            else-> navController.navigate (Report.route){ launchSingleTop = true }
        }
    }


    fun onProductItemClicked(id: Int, navController: NavController) {
        navController.navigate("product/$id")
    }

    fun onDeleteClicked(itemId: Int) {
        viewModelScope.launch {
            productRepository.deleteProduct(itemId)
            products.removeIf { it.id == itemId }
        }
    }

    fun updateSelectedNavBarItem(itemIndex: Int) {

        selectedBottomNavBarItem = itemIndex
    }

}

data class DashBoardScreenUiState(
    val taskListIsEmpty:Boolean = false,
    val isRefreshing:Boolean = false,
    val internetConnectionError:Boolean = false,
    val dataTurnedOff : Boolean = false,
    val loading:Boolean = false,

)