package com.example.geeksfit.data.remote.model

import com.example.geeksfit.data.remote.model.card.MyCard
import com.example.geeksfit.data.remote.model.fovoritetraining.FavoriteTraining
import com.example.geeksfit.data.remote.model.fovoritetraining.User
import com.example.geeksfit.data.remote.model.login.RegistrationBody
import com.example.geeksfit.data.remote.model.personalinform.PersonalInform
import com.example.geeksfit.data.remote.model.trainings.TrainingsResponse

data class Definitions(
    val FavoriteTraining: FavoriteTraining,
    val Login: Login,
    val MyCard: MyCard,
    val PersonalInform: PersonalInform,
    val Register: RegistrationBody,
    val Training: TrainingX,
    val TrainingDetail: TrainingsResponse,
    val User: User
)