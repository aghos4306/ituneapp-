package com.example.mvvmitunes.network

import com.example.mvvmitunes.utils.ITUNE_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    @Volatile
    private var RETROFIT_INSTANCE: Retrofit? = null

    fun getRetrofitClient(): Retrofit {
        return RETROFIT_INSTANCE ?: synchronized(this) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
            val currentInstance = Retrofit.Builder()
                .baseUrl(ITUNE_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            RETROFIT_INSTANCE = currentInstance
            currentInstance
        }
    }

    fun<T> getService(service: Class<T>) : T {
        return getRetrofitClient().create(service)
    }
}