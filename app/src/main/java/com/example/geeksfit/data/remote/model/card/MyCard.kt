package com.example.geeksfit.data.remote.model.card

data class MyCard(
    val properties: CardBody,
    val required: List<String>,
    val type: String
)