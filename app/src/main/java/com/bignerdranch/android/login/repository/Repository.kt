package com.bignerdranch.android.login.repository

import com.bignerdranch.android.login.api.RetrofitInstance
import com.bignerdranch.android.login.model.Login
import com.bignerdranch.android.login.model.User
import retrofit2.Response
import retrofit2.Retrofit


class Repository {
    suspend fun getUser(auth: String): Response<User>{
        return RetrofitInstance.api.getUser(auth)
    }

    suspend fun Auth(Login: Login): Response<Login> {
        return RetrofitInstance.api.auth(Login)
    }
}