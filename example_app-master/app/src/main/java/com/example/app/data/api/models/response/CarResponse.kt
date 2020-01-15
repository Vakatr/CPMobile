package com.example.app.data.api.models.response

data class CarResponse(
    val id: Long,
    val regNum:String,
    val brandOfCar:String,
    val modelOfCar:String,
    val typeOfBody:String,
    val typeOfTransport:String
)