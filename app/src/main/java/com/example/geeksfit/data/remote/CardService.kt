package com.example.geeksfit.data.remote

import com.example.geeksfit.data.remote.model.card.CardBody
import com.example.geeksfit.data.remote.model.card.MyCard
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface CardService {

    @GET("/personal_area/my_card/")
    fun getMyCard(): Call<List<CardBody>>

    @POST("/personal_area/my_card/")
    fun postMyCard(
        @Body myCard: CardBody
    ): Call<CardBody>

    @GET("/personal_area/my_card/{id}/")
    fun getMyCardId(
        @Path("id") id: Int
    ): Response<MyCard>

    @PUT("/personal_area/my_card/{id}/")
    fun putMyCardId(
        @Body myCard: MyCard
    ): Response<MyCard>

    @PATCH("/personal_area/my_card/{id}/")
    fun patchMyCardId(
        @Body myCard: MyCard
    ): Response<MyCard>

}