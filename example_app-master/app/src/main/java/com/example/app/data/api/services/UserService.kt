package com.example.app.data.api.services

import com.example.app.data.api.models.ChangePassword
import com.example.app.data.api.models.Login
import com.example.app.data.api.models.User
import com.example.app.data.api.models.response.TokenResponse
import com.example.app.data.api.models.response.UserResponse
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserService {
    @GET("/api/v1/users/profile")
    fun getProfile(): Single<UserResponse>

    @Headers("Content-Type: application/json")
    @POST("/api/v1/users/profile/change")
    fun editProfile(@Body dataUser: User): Single<UserResponse>

    @Headers("Content-Type: application/json")
    @POST("/api/v1/users/profile/changePassword")
    fun changePassword(@Body dataChangePassword: ChangePassword): Single<UserResponse>
}