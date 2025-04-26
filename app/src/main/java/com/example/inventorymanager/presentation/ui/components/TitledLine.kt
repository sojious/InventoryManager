package com.example.inventorymanager.presentation.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inventorymanager.presentation.theme.Mauve
import com.example.inventorymanager.presentation.theme.primaryBlue

@Composable
fun TitledLine(modifier: Modifier=Modifier, title:String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Text(
            text =title,
            color = primaryBlue,
            letterSpacing = 3.sp,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
        )
        HorizontalDivider(
            modifier = Modifier
                .padding(start = 16.dp,)
                .weight(1f),
            //.align(Alignment.CenterVertically)
            thickness = 0.8.dp, color = Mauve
        )

        //VerticalDivider()
    }
}

@Preview
@Composable
fun TitledLinePreview(){
    TitledLine(title = "Education")
}