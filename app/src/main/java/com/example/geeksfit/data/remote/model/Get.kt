package com.example.geeksfit.data.remote.model

data class Get(
    val description: String,
    val operationId: String,
    val parameters: List<Any>,
    val responses: Responses,
    val tags: List<String>
)