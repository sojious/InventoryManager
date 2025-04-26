package com.example.inventorymanager.presentation.ui.Dashboard

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inventorymanager.domain.model.RecentActivity
import com.example.inventorymanager.domain.model.Product
import com.example.inventorymanager.domain.model.StockCategory
import com.example.inventorymanager.presentation.theme.AntiFlashWhite1
import com.example.inventorymanager.presentation.theme.AntiFlashWhite2
import com.example.inventorymanager.presentation.theme.Tekhelet
import com.example.inventorymanager.presentation.theme.White
import com.example.inventorymanager.presentation.theme.primaryBlue
import com.example.inventorymanager.util.formatTimestamp
import com.example.inventorymanager.util.getStockCategoriesBreakdown
import com.example.inventorymanager.util.getTotalProductsOutOfStock
import com.example.inventorymanager.util.isFirstLaunch
import ir.ehsannarmani.compose_charts.PieChart
import ir.ehsannarmani.compose_charts.models.Pie


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DashBoardScreen(dashBoardViewModel: DashBoardViewModel) {

    val context = LocalContext.current

    LaunchedEffect(key1 = Unit) {
        val isFirstLaunch = isFirstLaunch(context)

        // only load data from mock remote API on first launch

        if (isFirstLaunch) {
           dashBoardViewModel.getProductsFromMockServer()
        }else{
            dashBoardViewModel.getProductsFromLocalDatabase()
        }
    }

    DashBoardScreenContent(products = dashBoardViewModel.products, recentActivity = dashBoardViewModel.recentActivities)
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DashBoardScreenContent(
    modifier: Modifier = Modifier,
    products: List<Product>,
    recentActivity: List<RecentActivity>,
) {


    Box(modifier = modifier.fillMaxSize()){
         HeaderSection()
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(color = White)
            //.padding(top = 16.dp),
            // verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {



            item { ProductStatSection(products = products) }
            item{ Spacer(modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth().height(1.dp).background(color = Tekhelet)) }
            item { CategoryBreakdownSection(products = products) }
            item{ Spacer(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top =16.dp).fillMaxWidth().height(1.dp).background(color = Tekhelet.copy(alpha = 0.2f))) }
            item { RecentActivitySection(recentActivities = recentActivity) }

            item{ Spacer(modifier = Modifier.padding(start = 16.dp,end = 16.dp, top = 12.dp, bottom = 5.dp).fillMaxWidth().height(1.dp).background(color = Tekhelet.copy(alpha = 0.2f))) }

            //item { StoresListSection(storesData = storesData) }
        }
    }


}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProductStatSection(modifier: Modifier = Modifier, products: List<Product>) {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(AntiFlashWhite1)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "DashBoard", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = modifier.fillMaxWidth().background(color = AntiFlashWhite1),
                //.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {

                ProductStatItem(
                    name = "Total Items",
                    value = products.size
                )

            ProductStatItem(
                name = "Items Out of Stock",
                value = getTotalProductsOutOfStock(products)
            )
        }


            /*Column(
                //verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                IconButton(
                    modifier = Modifier.clip(shape = CircleShape)
                        .background(color = primaryBlue.copy(alpha = 0.2f))
                        .padding(bottom = 10.dp), onClick = {

                    }
                ) {
                    Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = null)
                }

                Text(text = "View more", modifier = Modifier.padding(bottom = 8.dp), color = primaryBlue, fontSize = 12.sp)
            }*/
        }
    }



@Composable
fun HeaderSection(modifier: Modifier = Modifier, onMoreClicked: () -> Unit = {}) {
    Row(
        modifier = modifier.fillMaxWidth().background(color = AntiFlashWhite1).padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = onMoreClicked) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
        }
        Text(text = "Inventor.io", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Person, contentDescription = "Profile")
        }
    }
}


@Composable
fun ProductStatItem(modifier: Modifier = Modifier, name: String, value: Int){
    Box(
        modifier = modifier
            .background(Color.White, RoundedCornerShape(20.dp)),

        ){

        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Text(
                modifier = Modifier.padding(top= 20.dp),
                text = "$value",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = primaryBlue
            )

            Text(
                text = "Qty",
                fontSize = 11.sp,
                fontWeight = FontWeight.Normal,
                color = primaryBlue
            )

            Text(
                modifier = Modifier.padding(top= 15.dp, bottom = 25.dp),
                text = name,
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }

}





@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RecentActivitySection(modifier: Modifier = Modifier, recentActivities: List<RecentActivity>) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()

    ) {
        Text(
            text = "Recent Activities",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            modifier = Modifier.padding(top = 40.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Column( modifier = modifier
            //.padding(vertical = 20.dp)
            .fillMaxWidth(),
            //.clip(RoundedCornerShape(10.dp))
            //.background(AntiFlashWhite2),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            repeat(recentActivities.size){

                RecentActivityItem(
                    description = recentActivities[it].description,
                    date = recentActivities[it].timestamp,
                )
            }
        }


    }
}

@Composable
fun StoresListSection(modifier: Modifier = Modifier,storesData: List<String>) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()

    ) {
        Text(text = "Stores list", fontWeight = FontWeight.SemiBold, fontSize = 18.sp, modifier = Modifier.padding(top = 40.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Column(
            modifier = Modifier.fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .background(AntiFlashWhite2),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            repeat(storesData.size){
                StoreListItem(name = storesData[it], topPadding = it==0, bottomPadding = it==storesData.size-1)
            }
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RecentActivityItem(
    modifier: Modifier = Modifier,
    description: String,
    date: String,

) {

    Row(
        modifier = modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
        //horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = description,
            fontSize = 16.sp,
            color = Color.Black,
        )
        //Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = formatTimestamp(date), fontSize = 8.sp, color = Color.Black.copy(alpha = 0.5f),
            modifier = Modifier.padding(start = 10.dp),
            maxLines = 1
        )
    }
}

@Composable
fun StoreListItem(
    modifier: Modifier = Modifier,
    topPadding: Boolean=false,
    bottomPadding: Boolean = false,
    name: String
) {

    val topPaddingValue = if (topPadding) 20.dp else 0.dp
    val bottomPaddingValue = if (bottomPadding) 20.dp else 0.dp

    Row(
        modifier = modifier.fillMaxWidth().padding(top = topPaddingValue, bottom = bottomPaddingValue, start = 16.dp,end=16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = name, fontSize = 16.sp)
        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "More")
    }
}

@Composable
fun CategoryBreakdownSection(modifier: Modifier = Modifier, products: List<Product>){

    val categoriesBreakDown = getStockCategoriesBreakdown(products)
    var data by remember {
        mutableStateOf(
            List(categoriesBreakDown.size){ index ->
                Pie(label = categoriesBreakDown[index].label, data = categoriesBreakDown[index].count, color = Color.Red, selectedColor = Color.Green)
            }

        )
    }

   Column(modifier = modifier.padding(horizontal = 20.dp)) {

       Text(text = "Category", fontWeight = FontWeight.SemiBold, fontSize = 18.sp, modifier = Modifier.padding(top = 40.dp))
       Spacer(modifier = Modifier.height(8.dp))

       PieChart(
           modifier = Modifier.size(200.dp).padding(top=16.dp),
           data = data,
           onPieClick = {
               println("${it.label} Clicked")
               val pieIndex = data.indexOf(it)
               data = data.mapIndexed { mapIndex, pie -> pie.copy(selected = pieIndex == mapIndex) }
           },
           selectedScale = 1.2f,
           scaleAnimEnterSpec = spring<Float>(
               dampingRatio = Spring.DampingRatioMediumBouncy,
               stiffness = Spring.StiffnessLow
           ),
           colorAnimEnterSpec = tween(300),
           colorAnimExitSpec = tween(300),
           scaleAnimExitSpec = tween(300),
           spaceDegreeAnimExitSpec = tween(300),
           style = Pie.Style.Fill
       )

   }
}



@RequiresApi(Build.VERSION_CODES.O)
@Preview()
@Composable
fun DashboardScreenPreview() {
    //val chartData = mapOf("Confirmed" to 40.0, "Packed" to 60.0, "Refunded" to 20.0, "Shipped" to 60.0)
    //val stockData = mapOf("Item 1" to 10, "Item 2" to 5, "Item 3" to 8)
    //val activities =  mapOf("New Items" to 741, "New Orders" to 123, "Refunds" to 12, "Message" to 1, "Groups" to 4)
    //val storesData = listOf("Manchester, UK", "YorkShire, UK", "Hull, UK", "Leicester, UK")
    DashBoardScreenContent(
       products = mockProducts,
        recentActivity = mockActivities,
    )
}






@Preview(showBackground = true, backgroundColor = 0xFFE5D5F9)
@Composable
fun HeaderSectionPreview() {
    HeaderSection()
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, backgroundColor = 0xFFE5D5F9)
@Composable
fun RecentActivityItemPreview() {
    RecentActivityItem(description = "Added 'Samsung Galaxy A14' to Electronics", date = "2025-04-23T10:15:00Z")
}

@Preview
@Composable
fun StoresListSectionPreview() {
    val storesData = listOf("Manchester, UK", "YorkShire, UK", "Hull, UK", "Leicester, UK")
    StoresListSection(storesData = storesData)

}

val mockProducts = listOf(
    Product(
        1,
        "Laptop",
        15,
        2300.56,
        "2025-04-23T08:45:00Z","Electronics",
        imageUrl = "https://images.unsplash.com/photo-1525902003774-36865a3d995b?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8bGFwdG9wfGVufDB8fDB8fHww",
        description = "A powerful laptop for all your computing needs.",supplier = "Supplier A"
    ),
    Product(
        2,
        "Mouse",
        4, 1000.00,
        "2025-04-23T08:45:00Z",
        "Accessories",
        imageUrl = "https://images.unsplash.com/photo-1525902003774-36865a3d995b?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8bGFwdG9wfGVufDB8fDB8fHww",
        description = "A comfortable mouse for precise navigation.",
        supplier = "Supplier B",
    ),
    Product(
        3,
        "Printer",
        0,
        1500.00,
        "2025-04-23T08:45:00Z",
        "Office",
        imageUrl = "https://images.unsplash.com/photo-1525902003774-36865a3d995b?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8bGFwdG9wfGVufDB8fDB8fHww",
        description = "A high-quality printer for printing documents.",
        supplier = "Supplier C",
    ),
    Product(
        4,
        "Monitor",
        9,
        2000.00,
        "2025-04-23T08:45:00Z",
        "Electronics"
        ,imageUrl = "https://images.unsplash.com/photo-1525902003774-36865a3d995b?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8bGFwdG9wfGVufDB8fDB8fHww",
        description = "A large monitor for better viewing experience.",
        supplier = "Supplier D"
    ),
    Product(
        5,
        "Desk Lamp",
        22, 100.00,"2025-04-23T08:45:00Z",
        "Home",
        imageUrl = "https://images.unsplash.com/photo-1525902003774-36865a3d995b?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8bGFwdG9wfGVufDB8fDB8fHww",
        description = "A stylish desk lamp for your workspace.",
        supplier = "Supplier E"
    ),
    Product(6,
        "HDMI Cable",
        0,
        10.00,"2025-04-23T08:45:00Z",
        "Accessories",
        imageUrl = "https://images.unsplash.com/photo-1525902003774-36865a3d995b?q=80&w=1000&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8bGFwdG9wfGVufDB8fDB8fHww",
        description = "A high-quality HDMI cable for connecting devices.",
        supplier = "Supplier F"
    )
)

val mockCategoryData = listOf(StockCategory("Electronics", 40.0), StockCategory("Accessories", 60.0), StockCategory("Office", 20.0), StockCategory("Home", 60.0))
val mockActivities = listOf(

    RecentActivity(
        id = 1,
        type = "added",
        description = "Added 'Samsung Galaxy A14' to Electronics",
        timestamp ="2025-04-23T10:15:00Z"
    ),
    RecentActivity(
        id = 2,
        type = "updated",
        description = "Updated price of Redmi Note 11 Pro",
        timestamp ="2025-04-23T10:15:00Z"
    ),
    RecentActivity(
        id = 3,
        type = "deleted",
        description = "HP Deskjet 2130' is now out of stock",
        timestamp ="2025-04-23T10:15:00Z"
    )
)