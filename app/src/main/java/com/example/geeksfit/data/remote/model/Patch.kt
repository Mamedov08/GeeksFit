package com.example.geeksfit.data.remote.model

data class Patch(
    val description: String,
    val operationId: String,
    val tags: List<String>
)