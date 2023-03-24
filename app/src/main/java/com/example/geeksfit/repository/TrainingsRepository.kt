package com.example.geeksfit.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.geeksfit.core.Resource
import com.example.geeksfit.data.remote.TrainingsService
import com.example.geeksfit.data.remote.model.login.LoginResponse
import com.example.geeksfit.data.remote.model.trainings.ResponseTrainings
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class TrainingsRepository @Inject constructor(private val api: TrainingsService) {

    fun getTrainingsEasy(page :Int): LiveData<List<ResponseTrainings>> {
        val data = MutableLiveData<List<ResponseTrainings>>()
        api.getTrainingsEasy(page = page).enqueue(object : Callback<List<ResponseTrainings>> {
            override fun onResponse(
                call: Call<List<ResponseTrainings>>,
                response: Response<List<ResponseTrainings>>
            ) {
               if (response.isSuccessful){

                   data.postValue(response.body())
               }
            }

            override fun onFailure(call: Call<List<ResponseTrainings>>, t: Throwable) {
                print(t.stackTrace)
            }

        })
        return data

    }

  fun getTrainingsAdvanced(page :Int): LiveData<List<ResponseTrainings>>{
        val data = MutableLiveData<List<ResponseTrainings>>()

        api.getTrainingsAdvanced(page = page).enqueue(object : Callback<List<ResponseTrainings>>{
            override fun onResponse(
                call: Call<List<ResponseTrainings>>,
                response: Response<List<ResponseTrainings>>
            ) {
                if (response.isSuccessful){
                    data.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<ResponseTrainings>>, t: Throwable) {
                        }
        })

        return data
    }

    fun getTrainingsCounting(page :Int): LiveData<List<ResponseTrainings>>{
        val data = MutableLiveData<List<ResponseTrainings>>()

        api.getTrainingsCounting(page = page).enqueue(object : Callback<List<ResponseTrainings>>{
            override fun onResponse(
                call: Call<List<ResponseTrainings>>,
                response: Response<List<ResponseTrainings>>
            ) {
                if (response.isSuccessful){
                    data.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<List<ResponseTrainings>>, t: Throwable) {
                print(t.stackTrace)               }
        })

        return data
    }

}