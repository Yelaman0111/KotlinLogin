package com.bignerdranch.android.login.api

import com.bignerdranch.android.login.model.Login
import com.bignerdranch.android.login.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface SimpleApi {

    @POST("auth")
    suspend fun auth(
    @Body login: Login
    ): Response<Login>

    @GET("profile")
    suspend fun getUser(@Header("Auth") auth: String):Response<User>

//    @GET("profile")
//    suspend fun getUser():Response<User>
}