package com.example.inventorymanager.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OfflineScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F4F3)), // Light grayish background
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Take up most of the vertical space
        ) {
            Text(
                text = "Oops!",
                style = MaterialTheme.typography.headlineLarge.copy(color = Color(0xFF37474F)), // Dark grayish text
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "It looks\nyou are offline.",
                style = MaterialTheme.typography.titleSmall.copy(color = Color(0xFF78909C)), // Grayish blue text
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                painter = painterResource(id = android.R.drawable.presence_offline), // Replace with your image resource
                contentDescription = "Offline Kiwi",
                modifier = Modifier.size(200.dp)
            )
        }

        // Bottom Section
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Error You are currently offline",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color(0xFFE64A19)) // Orange error color
            )
            Button(
                onClick = { /* TODO: Implement retry logic */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1E88E5), contentColor = Color.White) // Blue button
            ) {
                Text(text = "Retry")
            }
        }
    }
}

@Preview
@Composable
fun PreviewOfflineScreen() {
    OfflineScreen()
}