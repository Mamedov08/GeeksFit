package com.example.geeksfit.data.remote.model.login

data class LoginResponse(
    val access_token: String,
    val messege: String,
    val status: Int,
    val token: String,
    val user: String
)