package io.jyryuitpro.shoppi.android.network

import io.jyryuitpro.shoppi.android.model.Category
import io.jyryuitpro.shoppi.android.model.CategoryDetail
import io.jyryuitpro.shoppi.android.model.Product
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("categories.json")
    suspend fun getCategories(): List<Category>

    @GET("fashion_female.json")
    suspend fun getCategoryDetail(): CategoryDetail

//    @GET("{categoryId}.json")
//    suspend fun getCategoryDetail(@Path("categoryId") categoryId: String): CategoryDetail

    @GET("products/{productId}.json")
    suspend fun getProductDetail(@Path("productId") productId: String): Product

    companion object {

        private const val baseUrl = "https://shoppi-b2d5f-default-rtdb.asia-southeast1.firebasedatabase.app"

        fun create(): ApiClient {

            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BASIC
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiClient::class.java)
        }
    }
}