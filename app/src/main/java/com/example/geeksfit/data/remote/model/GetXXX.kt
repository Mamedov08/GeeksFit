package com.example.geeksfit.data.remote.model

data class GetXXX(
    val description: String,
    val operationId: String,
    val parameters: List<Any>,
    val responses: ResponsesXXX,
    val tags: List<String>
)