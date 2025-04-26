package com.example.inventorymanager.presentation.ui.ProductList

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProductDetailsScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Make the screen scrollable
    ) {
        // Product Image
        AsyncImage(
            model = "https://via.placeholder.com/400", // Replace with your image URL
            contentDescription = "Product Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Product Title
        Text(
            text = "Unisex T-Shirt White", // Replace with product title
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Brand Name
        Text(
            text = "Unnamed Brand", // Replace with brand name
            style = MaterialTheme.typography.titleSmall.copy(color = Color.Gray)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Available Sizes
        Text(
            text = "Available sizes: XS, S, M, L, XL, XXL", // Replace with available sizes
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Category
        Text(
            text = "Category: T-shirts", // Replace with category
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Gender
        Text(
            text = "Gender: Male Female", // Replace with gender
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Product Code
        Text(
            text = "Product code: 119-12", // Replace with product code
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Order Name
        Text(
            text = "Order name: SKT19-111", // Replace with order name
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Store Availability
        Text(
            text = "Store availability",
            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Column {
            StoreAvailabilityItem(storeName = "Manchester, UK", available = true)
            StoreAvailabilityItem(storeName = "Yorkshire, UK", available = true)
            StoreAvailabilityItem(storeName = "Hull, UK", available = false)
            StoreAvailabilityItem(storeName = "Leicester, UK", available = true)
        }
    }
}

@Composable
fun StoreAvailabilityItem(storeName: String, available: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = storeName)
        Icon(
            imageVector = if (available) Icons.Filled.Check else Icons.Filled.Close,
            contentDescription = if (available) "Available" else "Not Available",
            tint = if (available) Color.Green else Color.Red
        )
    }
}

@Preview
@Composable
fun PreviewProductDetailsScreen() {
    ProductDetailsScreen()
}