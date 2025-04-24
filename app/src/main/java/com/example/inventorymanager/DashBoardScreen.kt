package com.example.inventorymanager

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.inventorymanager.ui.theme.primaryBlue
import ir.ehsannarmani.compose_charts.ColumnChart
import ir.ehsannarmani.compose_charts.models.BarProperties
import ir.ehsannarmani.compose_charts.models.Bars
import ir.ehsannarmani.compose_charts.models.DrawStyle

@Composable
fun DashboardScreen(
    modifier: Modifier = Modifier,
    salesData: Map<String, Double>,
    stockData: Map<String, Int>
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(White)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { HeaderSection() }
        item { RecentActivitySection() }
        item{
            Spacer(
                modifier = Modifier.padding(horizontal = 10.dp).fillMaxWidth()
                    .height(5.dp)
                    .background(color = Tekhelet)
            )
        }
        item { SaleSection(chartData = salesData) }
        item { StockStatusSection(stockData = stockData) }
        //item { TopItemCategoriesSection() }
        //item { LowStockItemsSection() }
        //item { StoresListSection() }
    }
}










@Composable
fun HeaderSection(modifier: Modifier = Modifier, onMoreClicked: () -> Unit = {}) {
    Row(
        modifier = modifier.fillMaxWidth(),
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
fun RecentActivitySection(modifier: Modifier = Modifier, name: String, value: Int){
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
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = primaryBlue
            )

            Text(
                text = "Qty",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = primaryBlue
            )

            Text(
                modifier = Modifier.padding(top= 15.dp, bottom = 25.dp),
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
        }
    }

}


@Composable
fun SaleSection(modifier: Modifier = Modifier, chartData: Map<String, Double>) {

    val colors = remember{listOf(Color.Red,Color.Green,Color.Blue,Color.Black)}
    Box(
        modifier = modifier.fillMaxWidth()
            .background(color = White, shape = RoundedCornerShape(20.dp)),
    ){

        ColumnChart(
            modifier = Modifier.fillMaxSize().padding(start = 20.dp, end=20.dp,top = 30.dp, bottom = 20.dp),
            data = remember {
                List(chartData.size){
                    Bars(
                        label = chartData.keys.elementAt(it),
                        values = listOf(
                            Bars.Data( value = chartData.values.elementAt(it), color = SolidColor(colors[it])),
                        )
                    )
                }
            },
            barProperties = BarProperties(
                cornerRadius = Bars.Data.Radius.Circular(10.dp),
                spacing = 1.dp,
                thickness = 20.dp,
                style = DrawStyle.Fill
            ),
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessLow
            ),
        )
    }

}



@Composable
fun StockStatusSection(modifier: Modifier = Modifier, stockData: Map<String, Int>) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(AntiFlashWhite2)
            .padding(16.dp)
    ) {
        Text(text = "Low stock items", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        repeat(stockData.size){
            StockStatusItem(label = stockData.keys.elementAt(it), count = stockData.values.elementAt(it).toString())
        }

    }
}

@Composable
fun StoresListSection(modifier: Modifier = Modifier,storesData: List<String>) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(White3)
            .padding(16.dp)
    ) {
        Text(text = "Stores list", fontWeight = FontWeight.SemiBold, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(8.dp))
        repeat(storesData.size){
            StoreListItem(name = storesData[it])
        }
    }
}

@Composable
fun StockStatusItem(modifier: Modifier = Modifier, label: String, count: String) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = label, fontSize = 16.sp)
        Text(text = count, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun StoreListItem(modifier: Modifier = Modifier,name: String) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = name, fontSize = 16.sp)
        Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight, contentDescription = "More")
    }
}


@Preview()
@Composable
fun DashboardScreenPreview() {
    //DashboardScreen(salesData = salesData)
}


@Preview()
@Composable
fun RecentActivitySectionPreview() {
    RecentActivitySection(name = "New Items", value =  741)
}


@Preview
@Composable
fun HeaderSectionPreview() {
    HeaderSection()
}

@Preview
@Composable
fun SalesSectionPreview() {
    val chartData = mapOf("Confirmed" to 40.0, "Packed" to 60.0, "Refunded" to 20.0, "Shipped" to 60.0)
    SaleSection(chartData = chartData)
}
@Preview
@Composable
fun StockStatusSectionPreview() {
    val stockData = mapOf("Item 1" to 10, "Item 2" to 5, "Item 3" to 8)
    StockStatusSection(stockData = stockData)
}

@Preview
@Composable
fun StoresListSectionPreview() {
    val storesData = listOf("Manchester, UK", "YorkShire, UK", "Hull, UK", "Leicester, UK")
    StoresListSection(storesData = storesData)

}