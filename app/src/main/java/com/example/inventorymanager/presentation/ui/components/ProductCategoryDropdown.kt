package com.example.inventorymanager.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inventorymanager.presentation.theme.primaryBlue
import com.example.inventorymanager.util.Category

/*@Composable
fun ProductCategoryDropDown(
    modifier: Modifier = Modifier,
    state: CVFormState
){

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        Row {
            Text(
                text ="Certificate Type",
                fontSize = 12.sp,
                color = primaryBlue,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "*",
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(start = 2.dp),
                fontSize = 12.sp
            )
        }


        Row(
            modifier= Modifier
                .fillMaxWidth()
                .height(47.dp)
                .border(width = 1.dp, color = primaryBlue, shape = RoundedCornerShape(8.dp))
                .clickable { state.toggleExpandedState() },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = state.selectedCertificateType.id, fontSize = 12.sp, color = primaryBlue,modifier=Modifier.padding(start = 12.dp))
            Spacer(modifier = Modifier.weight(1f))
            Image(painter = painterResource(id = R.drawable.ic_arrow_down), contentDescription =null,modifier=Modifier.padding(end=20.dp))
            DropdownMenu(
                expanded = state.dropDownExpanded,
                onDismissRequest = { state.toggleExpandedState()},
                modifier =Modifier.background(color= Color.White, shape = RoundedCornerShape(4.dp))

            ) {

                DropdownMenuItem(
                    text = { Text(text = Category.Accessories.name, fontSize = 12.sp, color = primaryBlue)},
                    onClick = { state.updateSelectedCertificateType(Category.Accessories);state.toggleExpandedState() },
                )

                DropdownMenuItem(
                    text = { Text(text = Category.Electronics.name, fontSize = 12.sp, color = primaryBlue)},
                    onClick = { state.updateSelectedCertificateType(Category.Electronics);state.toggleExpandedState() },
                )
                DropdownMenuItem(
                    text = { Text(text = Category.Home.name, fontSize = 12.sp, color = primaryBlue)},
                    onClick = { state.updateSelectedCertificateType(Category.Home);state.toggleExpandedState() },
                )

                DropdownMenuItem(
                    text = { Text(text = Category.Office.name , fontSize = 12.sp, color = primaryBlue)},
                    onClick = { state.updateSelectedCertificateType(Category.Office);state.toggleExpandedState() },

                    )

            }
        }
    }
}
*/

