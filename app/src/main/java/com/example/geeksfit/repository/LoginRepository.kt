package com.example.geeksfit.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.geeksfit.data.remote.ApiService
import com.example.geeksfit.data.remote.LoginService
import com.example.geeksfit.data.remote.model.login.LoginBody
import com.example.geeksfit.data.remote.model.login.LoginResponse
import com.example.geeksfit.data.remote.model.login.RegistrationBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: LoginService) {

    fun postLogin(loginBody: LoginBody): MutableLiveData<LoginResponse> {
        val data: MutableLiveData<LoginResponse> = MutableLiveData()
        api.postLogin(loginBody).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    data.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.e("raya", "onFailure: ${t.message}")

            }

        })
        return data
    }


    fun postRegistration(registrationBody: RegistrationBody): MutableLiveData<RegistrationBody> {
        val data: MutableLiveData<RegistrationBody> = MutableLiveData()
        api.postRegister(registrationBody).enqueue(object : Callback<RegistrationBody> {
            override fun onResponse(
                call: Call<RegistrationBody>,
                response: Response<RegistrationBody>
            ) {
                if (response.isSuccessful) {
                    data.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<RegistrationBody>, t: Throwable) {

                Log.e("raya", "onFailure: ${t.message}")
            }

        })
        return data
    }
}