package com.example.inventorymanager.data.remote

import android.content.Context
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class MockInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val uri = chain.request().url.toUri().toString()

        val fileName = when {
            uri.contains("products") -> "products.json"
            uri.contains("activities") -> "activities.json"
            else -> null
        }

        val json = fileName?.let {
            val inputStream = context.resources.openRawResource(
                context.resources.getIdentifier(it.removeSuffix(".json"), "raw", context.packageName)
            )
            inputStream.bufferedReader().use { it.readText() }
        } ?: "{}"

        return Response.Builder()
            .code(200)
            .message(json)
            .request(chain.request())
            .protocol(Protocol.HTTP_1_1)
            .body(json.toResponseBody("application/json".toMediaType()))
            .addHeader("content-type", "application/json")
            .build()
    }
}
