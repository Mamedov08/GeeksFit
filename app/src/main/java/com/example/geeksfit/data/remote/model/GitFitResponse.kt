package com.example.geeksfit.data.remote.model

data class GitFitResponse(
    val basePath: String,
    val consumes: List<String>,
    val definitions: Definitions,
    val host: String,
    val info: Info,
    val paths: Paths,
    val produces: List<String>,
    val schemes: List<String>,
    val security: List<Security>,
    val securityDefinitions: SecurityDefinitions,
    val swagger: String
)