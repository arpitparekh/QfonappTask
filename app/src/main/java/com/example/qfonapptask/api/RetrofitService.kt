package com.example.qfonapptask.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitService {
    companion object{
        private const val BASE_URL = "https://general.63-141-249-130.plesk.page/"
        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getInterface(): ApiInterface {
            return retrofit.create(ApiInterface::class.java)
        }

    }

}