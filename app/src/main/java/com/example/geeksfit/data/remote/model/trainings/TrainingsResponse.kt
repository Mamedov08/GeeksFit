package com.example.geeksfit.data.remote.model.trainings

data class TrainingsResponse(
    val count: Count,
    val next: Next,
    val previous: Previous,
    val results: Results
)