package com.example.compose.models

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

data class User(val email: String, val password: String)

data class ApiResponse(
    @Keep
    @SerializedName("status")
    val status: Boolean? = false,
    @SerializedName("statusCode")
    val statusCode: Int? = 0,
    @SerializedName("message")
    val message: String? = "",
    @SerializedName("result")
    val result: Result? = null
)

data class Result(
    @Keep
    @SerializedName("username")
    val userName: String?
)