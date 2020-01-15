package com.example.app.data.api.services

import com.example.app.data.api.models.Login
import com.example.app.data.api.models.response.TokenResponse
import com.example.app.data.api.models.User
import com.example.app.data.api.models.response.UserResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginService {
    @Headers("Content-Type: application/json")
    @POST("/api/v1/auth/login")
    fun login(@Body dataLogin: Login): Single<TokenResponse>

    @POST("/api/v1/auth/register")
    fun register(@Body dataUser: User): Single<UserResponse>

}