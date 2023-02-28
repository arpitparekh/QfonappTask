package com.example.qfonapptask.api

import com.example.qfonapptask.model.Content
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("qfonapp-interview/api.json")
    fun getContents() : Call<Content>
}