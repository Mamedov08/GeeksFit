package com.example.geeksfit.data.remote

import com.example.geeksfit.data.remote.model.Login
import com.example.geeksfit.data.remote.model.login.LoginBody
import com.example.geeksfit.data.remote.model.login.LoginResponse
import com.example.geeksfit.data.remote.model.login.RegistrationBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginService {

    @GET("users/login/")
    fun getLogin(): Call<LoginBody>

    @POST("users/login/")
    fun postLogin(
        @Body login: LoginBody
    ): Call<LoginResponse>

    @GET("users/register/")
    fun getRegister(): Call<RegistrationBody>

    @POST("users/register/")
    fun postRegister(
        @Body register: RegistrationBody
    ): Call<RegistrationBody>



}