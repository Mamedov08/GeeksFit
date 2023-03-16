package com.example.geeksfit.data.remote.model

data class GetXX(
    val description: String,
    val operationId: String,
    val parameters: List<ParameterX>,
    val responses: ResponsesXX,
    val tags: List<String>
)