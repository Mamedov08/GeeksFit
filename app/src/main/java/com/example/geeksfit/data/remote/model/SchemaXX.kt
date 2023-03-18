package com.example.geeksfit.data.remote.model

import com.example.geeksfit.data.remote.model.trainings.TrainingsResponse

data class SchemaXX(
    val properties: TrainingsResponse,
    val required: List<String>,
    val type: String
)