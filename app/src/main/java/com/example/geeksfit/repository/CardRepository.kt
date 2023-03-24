package com.example.geeksfit.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.geeksfit.data.remote.CardService
import com.example.geeksfit.data.remote.model.card.CardBody

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CardRepository @Inject constructor(private val api: CardService) {

    fun addMyCard(card: CardBody): MutableLiveData<CardBody> {
        val data: MutableLiveData<CardBody> = MutableLiveData()
        api.postMyCard(card).enqueue(object : Callback<CardBody> {
            override fun onResponse(call: Call<CardBody>, response: Response<CardBody>) {
                if (response.isSuccessful) {
                    data.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<CardBody>, t: Throwable) {
                Log.e("raya", "onFailure: ${t.message}")
            }

        })
        return data
    }

    fun getMyCard(): MutableLiveData<List<CardBody>> {
        val data: MutableLiveData<List<CardBody>> = MutableLiveData()

        api.getMyCard().enqueue(object : Callback<List<CardBody>> {
            override fun onResponse(
                call: Call<List<CardBody>>,
                response: Response<List<CardBody>>
            ) {
                if (response.isSuccessful) {
                    data.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<List<CardBody>>, t: Throwable) {
                Log.e("raya", "onFailure: ${t.message}")
            }
        })

        return data

    }
}