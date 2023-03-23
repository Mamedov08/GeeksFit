package com.example.geeksfit.data.remote.model.login

import com.example.geeksfit.data.remote.model.Password
import com.example.geeksfit.data.remote.model.Username

data class LoginBody(
    val password: String,
    val username: String
)