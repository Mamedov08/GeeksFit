package com.example.geeksfit.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.geeksfit.data.remote.ApiService
import com.example.geeksfit.data.remote.model.personalinform.PersonalInform
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository@Inject constructor(private val api: ApiService) {

    fun getPersonalInform(): MutableLiveData<PersonalInform> {
        val data : MutableLiveData<PersonalInform> = MutableLiveData()
        api.getPersonalInformView().enqueue(object : Callback<PersonalInform> {
            override fun onResponse(call: Call<PersonalInform>, response: Response<PersonalInform>) {
                if(response.isSuccessful){
                    data.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<PersonalInform>, t: Throwable) {
                Log.e("raya","onFailure: ${t.message}")
            }

        })
        return data
    }
}