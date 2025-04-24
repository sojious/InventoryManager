package com.example.inventorymanager

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.background
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

// Color definitions
val White = Color(0xFFFFFFFF)
val PalePurple = Color(0xFFE5D5F9)
val AntiFlashWhite1 = Color(0xFFF1F0F2)
val AntiFlashWhite2 = Color(0xFFECECEC)
val White3 = Color(0xFFFEFEFE)
val Mauve = Color(0xFFD0B4F1)
val Tekhelet = Color(0xFF51228B)
val Magnolia = Color(0xFFE9E6EC)
val Thistle = Color(0xFFE4D4F8)

@Composable
fun InventoryScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { HeaderSection() }
        item { RecentActivitySection() }
        item { SalesSection() }
        item { TopItemCategoriesSection() }
        item { StockStatusSection() }
        item { StoresListSection() }
    }
}



@Composable
fun RecentActivitySection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(AntiFlashWhite1)
            .padding(16.dp)
    ) {
        Text(text = "Recent activity", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ActivityCard(count = "741", label = "New Items")
            ActivityCard(count = "123", label = "New Orders")
            ActivityCard(count = "12", label = "Refunds")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ActivityCard(count = "4", label = "Messages")
            ActivityCard(count = "6", label = "Groups")
            ActivityCard(count = "1", label = "Voice Rec")
        }
    }
}

@Composable
fun ActivityCard(count: String, label: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(White3)
            .padding(10.dp)
    ) {
        Text(text = count, fontWeight = FontWeight.Bold, fontSize = 24.sp, color = Tekhelet)
        Text(text = label, fontSize = 12.sp, color = Tekhelet)
    }
}

@Composable
fun SalesSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(PalePurple)
            .padding(16.dp)
    ) {
        Text(text = "Sales", fontWeight = FontWeight.SemiBold, fontSize = 18.sp, color = Tekhelet)
        // Placeholder for graph - replace with actual graph implementation
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Magnolia)
        )
    }
}

@Composable
fun TopItemCategoriesSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Magnolia)
            .padding(16.dp)
    ) {
        Text(text = "Top item categories", fontWeight = FontWeight.SemiBold, fontSize = 18.sp, color = Tekhelet)
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryCard(icon = Icons.Default.ShoppingCart, description = "T-shirt") // Replace with actual icons
            CategoryCard(icon = Icons.Default.ShoppingCart, description = "Hats")
            CategoryCard(icon = Icons.Default.ShoppingCart, description = "Bags")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CategoryCard(icon = Icons.Default.ShoppingCart, description = "Shoes")
            CategoryCard(icon = Icons.Default.ShoppingCart, description = "Box")
            CategoryCard(icon = Icons.Default.ShoppingCart, description = "Glass")
        }
    }
}

@Composable
fun CategoryCard(icon: ImageVector, description: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Thistle)
            .padding(10.dp)
    ) {
        Icon(imageVector = icon, contentDescription = description, tint = Tekhelet)
        Text(text = description, fontSize = 12.sp, color = Tekhelet)
    }
}






@Preview(showBackground = true)
@Composable
fun InventoryScreenPreview() {
    InventoryScreen()
}