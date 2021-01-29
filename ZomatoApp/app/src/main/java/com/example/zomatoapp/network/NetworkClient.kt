package com.example.zomatoapp.network

import com.example.zomatoapp.api.Myinterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkClient {
    private val BASE_URL = "https://developers.zomato.com/"
    private val TIMEOUT = 10
    var retrofit: Retrofit? = null
//    private val client = OkHttpClient.Builder().apply {
//        addInterceptor(Myinterceptor())
//    }.build()

    val retrofitClient: Retrofit
        get() {
            if (retrofit == null) {
                val okHttpClientBuilder = OkHttpClient.Builder()
                okHttpClientBuilder.connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)

                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!
        }
}