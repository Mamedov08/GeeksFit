package com.example.geeksfit.data.remote

import com.example.geeksfit.data.remote.model.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("/geeksfit/favoritetrainings/")
    fun getFavoriteTrainings(): Response<FavoriteTraining>

    @GET("/geeksfit/favoritetrainings/{id}/")
    fun getFavoriteTrainingsId(
        @Path("id") id: Int
    ): Response<FavoriteTraining>

    @GET("/geeksfit/trainings/{id}/")
    fun getTrainingsId(
        @Path("id") id: Int
    ): Response<Training>

    @GET("/geeksfit/trainings/")
    fun getTrainings(
        @Query("page") page: Int
    ): Response<Training>

    @GET("/personal_area/my_card/")
    fun getMyCard(): Response<MyCard>

    @POST("/personal_area/my_card/")
    fun postMyCard(
        @Body myCard: MyCard
    ): Response<MyCard>

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

    @GET("/personal_area/personal_inform_edit/{id}/")
    fun getPersonalInform(): Response<PersonalInform>

    @PUT("/personal_area/personal_inform_edit/{id}/")
    fun putPersonalInform(
        @Body personal: PersonalInform
    ): Response<PersonalInform>

    @PATCH("/personal_area/personal_inform_edit/{id}/")
    fun patchPersonalInform(
        @Body personal: PersonalInform
    ): Response<PersonalInform>

    @GET("/personal_area/personal_inform_view/")
    fun getPersonalInformView(): Response<PersonalInform>

    @POST("/personal_area/personal_inform_view/")
    fun postPersonalInformView(
        @Body personal: PersonalInform
    ): Response<PersonalInform>

    @GET("/personal_area/profile_email/")
    fun getUser(
        @Body personal: PersonalInform
    ): Response<PersonalInform>

    @PUT("/personal_area/profile_email/")
    fun putUser(
        @Body personal: PersonalInform
    ): Response<PersonalInform>

    @PATCH("/personal_area/profile_email/")
    fun patchUser(
        @Body personal: PersonalInform
    ): Response<PersonalInform>

    @GET("users/login/")
    fun getLogin(): Response<Login>

    @POST("users/login/")
    fun postLogin(
        @Body login: Login
    ): Response<Login>

    @GET("users/register/")
    fun getRegister(): Response<Register>

    @POST("users/register/")
    fun postRegister(
        @Body register: Register
    ): Response<Register>


}