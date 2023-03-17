package com.example.geeksfit.data.remote.model

data class Parameter(
    val description: String,
    val `in`: String,
    val name: String,
    val required: Boolean,
    val type: String
)