package com.example.app.data.api.models.response

import java.time.LocalDateTime

data class UserResponse(
    val id:String,
    val name:String,
    val firstName:String,
    val lastName:String,
    val userPic:String,
    val email:String,
    val gender:String,
    val locale:String,
    val status:String,
    val lastVisit: LocalDateTime,
    val roles:List<String>
)