package com.example.geeksfit.data.remote

import com.example.geeksfit.data.remote.model.trainings.ResponseTrainings
import com.example.geeksfit.data.remote.model.trainings.Trainings
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TrainingsService {

    @GET("geeksfit/trainings_level_easy/")
    fun getTrainingsEasy(@Query("page") page:Int):Call<List<ResponseTrainings>>

    @GET("geeksfit/trainings_level_counting/")
    fun getTrainingsCounting(@Query("page") page:Int):Call<List<ResponseTrainings>>

    @GET("geeksfit/trainings_level_advanced/")
    fun getTrainingsAdvanced(@Query("page") page:Int):Call<List<ResponseTrainings>>

}