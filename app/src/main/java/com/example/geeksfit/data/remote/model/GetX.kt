package com.example.geeksfit.data.remote.model

data class GetX(
    val description: String,
    val operationId: String,
    val parameters: List<Any>,
    val responses: ResponsesX,
    val tags: List<String>
)