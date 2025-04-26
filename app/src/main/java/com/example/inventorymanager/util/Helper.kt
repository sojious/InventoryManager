package com.example.inventorymanager.util

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.inventorymanager.domain.model.Product
import com.example.inventorymanager.domain.model.StockCategory
import java.text.NumberFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale
import androidx.core.content.edit

fun getTotalProductsOutOfStock(products: List<Product>): Int {
    val inStock = products.count { it.quantity > 10 }
    val lowStock = products.count { it.quantity in 1..10 }
    val outOfStock = products.count { it.quantity == 0 }


    val outOfStockProducts = products.filter { it.quantity == 0 }

    return outOfStockProducts.size
}

fun getOutOfStockProducts(products: List<Product>): List<Product> = products.filter { it.quantity == 0 }

fun getStockCategoriesBreakdown(products: List<Product>): List<StockCategory> {

    val electronics = StockCategory(Category.Electronics.name, products.filter { it.category == Category.Electronics.name }.size.toDouble())
    val accessories = StockCategory(Category.Accessories.name, products.filter { it.category == Category.Accessories.name }.size.toDouble())
    val office = StockCategory(Category.Office.name, products.filter { it.category == Category.Office.name }.size.toDouble())
    val home = StockCategory(Category.Home.name, products.filter { it.category == Category.Home.name }.size.toDouble())
    return listOf(electronics, accessories, office, home)


}

@RequiresApi(Build.VERSION_CODES.O)
fun formatTimestamp(input: String): String {
    // Parse the ISO 8601 timestamp
    val zonedDateTime = ZonedDateTime.parse(input).withZoneSameInstant(ZoneId.systemDefault())

    val timeFormatter = DateTimeFormatter.ofPattern("h:mma", Locale.getDefault())
    val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault())

    val inputDate = zonedDateTime.toLocalDate()
    val today = LocalDate.now()
    val yesterday = today.minusDays(1)

    val timePart = zonedDateTime.format(timeFormatter)

    return when (inputDate) {
        today -> "Today, $timePart"
        yesterday -> "Yesterday, $timePart"
        else -> "${inputDate.format(dateFormatter)}, $timePart"
    }
}



fun formatCurrency(amount: Double): String {
    val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault())
    return format.format(amount)
}

fun isFirstLaunch(context: Context): Boolean {
    val prefs = context.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
    val isFirstTime = prefs.getBoolean("is_first_launch", true)

    if (isFirstTime) {
        prefs.edit() { putBoolean("is_first_launch", false) }
    }

    return isFirstTime
}





enum class Category{
    Electronics,
    Accessories,
    Office,
    Home,
}