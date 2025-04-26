package com.example.inventorymanager.presentation.ui.Addproduct

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.inventorymanager.util.Category

class AddProductViewModel: ViewModel() {
    var productName by mutableStateOf("")
        private set
    var productQuantity by mutableStateOf(0)
        private set
    var productPrice by mutableStateOf(0.0)
        private set
    var productDescription by mutableStateOf("")
        private set

    var productSupplierInfo by mutableStateOf("")
        private set
    var productImageUrl by mutableStateOf("")
        private set
    var productCategory by mutableStateOf(Category.Accessories)
        private set
    var dropDownExpanded by mutableStateOf(false)
        private set

}
