package com.example.geeksfit.data.repository

import com.example.geeksfit.data.remote.RegistApi
import com.example.geeksfit.data.remote.model.Password
import com.example.geeksfit.data.remote.model.PropertiesXXXX
import com.example.geeksfit.data.remote.model.Register

class RegistRepository(val registApi: RegistApi) {

    suspend fun register(username: String, email: String,password: String){}
}