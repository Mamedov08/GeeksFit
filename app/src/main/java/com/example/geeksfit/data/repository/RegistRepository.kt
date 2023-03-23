package com.example.geeksfit.data.repository

import com.example.geeksfit.data.remote.RegistApi

class RegistRepository(val registApi: RegistApi) {

    suspend fun register(username: String, email: String,password: String){}
}