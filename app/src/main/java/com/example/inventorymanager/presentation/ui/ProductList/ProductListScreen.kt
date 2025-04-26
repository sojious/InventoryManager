package com.example.inventorymanager.presentation.ui.ProductList

import android.R
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.inventorymanager.domain.model.Product
import com.example.inventorymanager.presentation.theme.Mauve
import com.example.inventorymanager.presentation.ui.Dashboard.DashBoardViewModel
import com.example.inventorymanager.util.Category
import com.example.inventorymanager.util.formatCurrency
import com.example.inventorymanager.util.formatTimestamp


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProductListScreen(
    modifier: Modifier = Modifier,
    dashBoardViewModel: DashBoardViewModel,
    navController: NavController
) {
    Column(modifier = modifier.fillMaxSize().background(Color.White)) {
        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Products",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                leadingIcon = { Icon(imageVector = AppIcons.Search, contentDescription = "Search") },
                //placeholder = { Text("Search products") },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(8.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = { },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors()
            ) {
                Icon(imageVector = AppIcons.Filter, contentDescription = "Filter", tint = Color.Gray)
                Text("Filter", color = Color.Gray)
            }
        }

        // Product List
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(dashBoardViewModel.products.size-1) { index ->
                ProductCard(
                    product = dashBoardViewModel.products[index],
                    dashBoardViewModel = dashBoardViewModel,
                    navController = navController
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ProductCard(
    modifier :Modifier = Modifier,
    dashBoardViewModel:DashBoardViewModel,
    product: Product,
    navController: NavController
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable{
                dashBoardViewModel.onProductItemClicked(product.id,navController)
                      },
        verticalAlignment = Alignment.CenterVertically
    ) {
            AsyncImage(
                model = product.imageUrl,
                contentDescription = product.name,
                modifier = Modifier
                    .size(120.dp,150.dp)
                    .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.ic_menu_gallery) // Placeholder
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(product.name, style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold))
                Text("Stock : ${product.quantity} in stock", style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray))
                Text("Price : ${formatCurrency(product.price)}", style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray))
                Text("Last Updated : ${formatTimestamp(product.lastUpdated)}", style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Button(
                        onClick = {  },
                        shape = RoundedCornerShape(4.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (product.quantity != 0) Color(0xFFBA68C8) else Color.Gray,
                            contentColor = Color.White
                        ),
                        modifier = Modifier.height(32.dp)
                    ) {
                        Text(if (product.quantity != 0) "Active" else "Sold out", style = TextStyle(fontSize = 12.sp))
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_media_play), // Placeholder arrow
                        contentDescription = "View Details",
                        tint = Color(0xFFBA68C8),
                        modifier = Modifier.size(20.dp)
                    )
                }
                //Text(product.name, style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold), modifier = Modifier.padding(top = 8.dp))
            }

        IconButton(
            onClick = {dashBoardViewModel.onDeleteClicked(product.id)},
            modifier = Modifier.align(Alignment.Bottom)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu_delete), // Placeholder arrow
                contentDescription = "Delete Product",
                tint = Color.Black.copy(alpha = 0.8f),
                //modifier = Modifier.size(20.dp)
            )
        }
    }

}



/*@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PreviewProductsScreen() {
    ProductsScreen()
}*/


val sampleProductList = listOf(
    Product(
        imageUrl = "https://via.placeholder.com/150/EEEEEE/000000?Text=White+T-Shirt",
        category = Category.Accessories.name,
        name = "Unisex T-Shirt White",
        id = 1,
        quantity = 12,
        price = 2800.0,
        lastUpdated = "2025-04-23T08:45:00Z",
        description = "A comfortable and stylish white t-shirt suitable for both men and women.",
        supplier = "Supplier A",
    ),
    Product(
        imageUrl = "https://via.placeholder.com/150/222222/FFFFFF?Text=Black+T-Shirt",
        category = "Category: T-shirts",
        name = "Unisex T-Shirt Black",
        id = 2,
        quantity = 0,
        price = 1500.0,
        lastUpdated = "2025-04-23T08:45:00Z",
        description = "A classic black t-shirt perfect for casual wear.",
        supplier = "Supplier B",
    ),
    Product(
        imageUrl = "https://via.placeholder.com/150/FFDA63/000000?Text=Yellow+Raincoat",
        category = "Category: T-shirts",
        name = "Rain Jacket Male",
        id = 3,
        quantity = 0,
        price = 18000.00,
        lastUpdated = "2025-04-23T08:45:00Z",
        description = "A waterproof raincoat for men, ideal for rainy days.",
        supplier = "Supplier C"
    ),
    Product(
        imageUrl = "https://via.placeholder.com/150/F5F5DC/000000?Text=Beige+Bomber",
        category = "Category: T-shirts",
        name = "Bomber Jacket Male",
        id = 4,
        quantity = 7,
        price = 1700.00,
        lastUpdated = "2025-04-23T08:45:00Z",
        description = "A stylish bomber jacket for men, perfect for layering.",
        supplier = "Supplier D"
    ),
    Product(
        imageUrl = "https://via.placeholder.com/150/ADD8E6/000000?Text=Denim+Shorts",
        category = "Category: T-shirts",
        name = "Denim Shorts Women",
        id = 5,
        quantity = 13,
        price = 3000.0,
        lastUpdated = "2025-04-23T08:45:00Z",
        description = "Comfortable denim shorts for women, great for summer.",
        supplier = "Supplier E"
    ),
    Product(
        imageUrl = "https://via.placeholder.com/150/006400/FFFFFF?Text=Green+Socks",
        category = "Category: T-shirts",
        name = "Unisex Socks Black",
        id = 6,
        quantity = 30,
        price = 4800.0,
        lastUpdated = "2025-04-23T08:45:00Z",
        description = "A pair of comfortable black socks suitable for both men and women.",
        supplier = "Supplier E"
    )
)

object AppIcons {
    val Menu = Icons.Filled.Person
    val Search = Icons.Filled.Search
    val Filter = Icons.Filled.Build
    val Person = Icons.Filled.AccountBox
}

