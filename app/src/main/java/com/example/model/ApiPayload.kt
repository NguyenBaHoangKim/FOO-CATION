package com.example.model


data class LoginResp(
    val user: User,
    val accessKey: String,
    val refreshKey: String
)

data class LoginRequest(
    val email: String,
    val password: String
)