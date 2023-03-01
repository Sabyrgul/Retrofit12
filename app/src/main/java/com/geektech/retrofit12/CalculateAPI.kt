package com.geektech.retrofit12

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CalculateAPI {

    @GET("getPercentage")
    fun getPercentage(
        @Query("sname") secondName:String,
        @Query("fname") firstName:String,
        @Header("X-RapidAPI-key")apiKey:String="9f2b90dc4bmsh47f22a0adf20dc7p11affajsn08ae8464d2e"
    ): Call<CalculateModel>
}