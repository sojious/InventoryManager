package com.example.inventorymanager.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SideNavigationMenu() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF673AB7)) // Deep Purple color
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Top Section (Close Icon and Title)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 48.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "Close",
                tint = Color.White,
                modifier = Modifier.clickable {
                    // Handle close action here
                    println("Close clicked")
                }
            )
            Text(
                text = "Inventor. io",
                style = TextStyle(
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
            Spacer(modifier = Modifier.width(24.dp)) // Add space to align title to the center
        }

        // Middle Section (Menu Items)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            val menuItems = listOf("Home", "Products", "Categories", "Stores", "Finances", "Settings")
            repeat(menuItems.size){
                MenuItem(text = menuItems[it]) {
                    println("Home clicked")
                }
            }

        }

        // Bottom Section (Log out)
        Text(
            text = "Log out",
            style = TextStyle(
                color = Color.White,
                fontSize = 20.sp
            ),
            modifier = Modifier
                .padding(top = 48.dp)
                .clickable {
                    // Handle Log out click
                    println("Log out clicked")
                }
        )
    }
}

@Composable
fun MenuItem(text: String, onClick: () -> Unit) {
    Text(
        text = text,
        style = TextStyle(
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        ),
        modifier = Modifier.clickable(onClick = onClick)
    )
}
@Preview
@Composable
fun PreviewSideNavigationMenu() {
    SideNavigationMenu()
}