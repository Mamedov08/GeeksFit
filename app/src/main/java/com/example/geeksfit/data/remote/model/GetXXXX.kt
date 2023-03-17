package com.example.geeksfit.data.remote.model

data class GetXXXX(
    val description: String,
    val operationId: String,
    val parameters: List<Any>,
    val responses: ResponsesXXXX,
    val tags: List<String>
)