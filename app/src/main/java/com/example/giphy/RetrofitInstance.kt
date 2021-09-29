package com.example.giphy

import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit


object RetrofitInstance {
    private var retrofit: Retrofit? = null
//    private const val BASE_URL = "https://api.jsonserve.com/"
private  const val BASE_URL ="https://api.giphy.com/"
    /**
     * Create an instance of Retrofit object
     */
    val retrofitInstance: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }
}