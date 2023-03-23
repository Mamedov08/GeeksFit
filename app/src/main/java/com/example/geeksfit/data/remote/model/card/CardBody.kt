package com.example.geeksfit.data.remote.model.card

data class CardBody(
    val card_number: String,
    val cvc: Int,
    val full_name: String,
    val month: Int,
    val year: Int
)