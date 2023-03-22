package com.example.geeksfit.data.remote

import com.example.geeksfit.data.remote.model.Login
import com.example.geeksfit.data.remote.model.PropertiesXXXX
import com.example.geeksfit.data.remote.model.Register
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface RegistApi {
    @GET("users/login/")
    fun getLogin(): retrofit2.Response<Login>

    @POST("users/login/")
    fun postLogin(
        @Body login: Login
    ): retrofit2.Response<Login>

    @GET("users/register/")
    fun getRegister(): retrofit2.Response<Register>

    @POST("users/register/")
    fun postRegister(
        @Body register: PropertiesXXXX
    ): retrofit2.Response<Register>
}