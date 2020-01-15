package com.example.app.data.api.models.response

import java.time.LocalDateTime

data class MessageResponse(
    val id: Long,
    val title:String,
    val text:String,
    val dateOfCrash: LocalDateTime,
    val created:LocalDateTime,
    val updated:LocalDateTime,
    val messageStatus: String,
    val x: Double,
    val y: Double,
    val car1:CarResponse,
    val car2:CarResponse,
    val street1:String,
    val street2:String,
    val typeOfRoadObj:String,
    val images:Set<String>,
    val comments:Set<String>,
    val author: UserResponse
)