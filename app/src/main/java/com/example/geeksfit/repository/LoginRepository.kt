package com.example.geeksfit.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.geeksfit.core.Resource
import com.example.geeksfit.data.remote.LoginService
import com.example.geeksfit.data.remote.model.login.LoginBody
import com.example.geeksfit.data.remote.model.login.LoginResponse
import com.example.geeksfit.data.remote.model.login.RegistrationBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: LoginService) {

    fun postLogin(loginBody: LoginBody): LiveData<Resource<LoginResponse>> {
        val data = MutableLiveData<Resource<LoginResponse>>()
        data.value = Resource.loading()

        api.postLogin(loginBody).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    data.value = Resource.success(response.body())
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                print(t.stackTrace)
                data.value = Resource.error(t.stackTrace.toString(), null, null)

            }

        })
        return data
    }


    fun postRegistration(registrationBody: RegistrationBody): LiveData<Resource<RegistrationBody>> {
        val data= MutableLiveData<Resource<RegistrationBody>>()
        data.value = Resource.loading()

        api.postRegister(registrationBody).enqueue(object : Callback<RegistrationBody> {
            override fun onResponse(
                call: Call<RegistrationBody>,
                response: Response<RegistrationBody>
            ) {
                if (response.isSuccessful) {
                    data.value = Resource.success(response.body())
                }
            }

            override fun onFailure(call: Call<RegistrationBody>, t: Throwable) {
                print(t.stackTrace)
                data.value = Resource.error(t.stackTrace.toString(), null, null)
            }

        })
        return data
    }
}