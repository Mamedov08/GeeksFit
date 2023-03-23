package com.example.geeksfit.data.remote.model.personalinform

data class PersonalInform(
    val properties: PersonalInformResponse,
    val required: List<String>,
    val type: String
)