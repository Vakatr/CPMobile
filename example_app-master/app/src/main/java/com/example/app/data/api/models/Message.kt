package com.example.app.data.api.models

import java.time.LocalDateTime

data class Message(
    val title:String,
    val text:String,
    val dateOfCrash: LocalDateTime,
    val created:LocalDateTime,
    val updated:LocalDateTime,
    val x: Double,
    val y: Double,
    val car1:Car,
    val car2:Car,
    val street1:String,
    val street2:String,
    val typeOfRoadObj:String,
    val images:Set<String>,
    val comments:Set<String>
)