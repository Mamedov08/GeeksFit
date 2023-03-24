package com.example.geeksfit.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.geeksfit.core.Resource
import com.example.geeksfit.data.local.Pref
import com.example.geeksfit.data.remote.model.login.LoginBody
import com.example.geeksfit.data.remote.model.login.LoginResponse
import com.example.geeksfit.data.remote.model.login.RegistrationBody
import com.example.geeksfit.repository.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class   RegistrationViewModel @Inject constructor(private val repository: LoginRepository, var pref: Pref) : ViewModel() {

    fun addRegistration(reg: RegistrationBody): LiveData<Resource<RegistrationBody>> {
        return repository.postRegistration(registrationBody = reg)
    }

    fun postLogin(loginBody: LoginBody): LiveData<Resource<LoginResponse>>{
        return repository.postLogin(loginBody)
    }


    fun saveTokens(loginResponse: LoginResponse){
        pref.saveToken(loginResponse.token)
        pref.saveAccessToken(loginResponse.access_token)
    }

    fun saveName(reg: RegistrationBody){
        pref.saveName(reg.username)
        pref.saveEmail(reg.email)
    }

}