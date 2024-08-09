package com.example.compose.retrofit

import com.example.compose.models.ApiResponse
import com.example.compose.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("users/email_login")
    fun loginUser(@Body user: User): Call<ApiResponse>
}