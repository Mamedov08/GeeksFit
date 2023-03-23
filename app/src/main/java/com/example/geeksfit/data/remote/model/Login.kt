package com.example.geeksfit.data.remote.model

import com.example.geeksfit.data.remote.model.login.LoginBody

data class Login(
    val properties: LoginBody,
    val required: List<String>,
    val type: String
)