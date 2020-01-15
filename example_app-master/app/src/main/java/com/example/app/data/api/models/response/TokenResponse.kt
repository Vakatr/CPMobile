package com.example.app.data.api.models.response

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @SerializedName("username") val name: String,
    @SerializedName("token") val token: String
)