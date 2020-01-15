package com.example.app.data.api.services

import com.example.app.data.api.models.Login
import com.example.app.data.api.models.Message
import com.example.app.data.api.models.response.ListMessageResponse
import com.example.app.data.api.models.response.MessageResponse
import com.example.app.data.api.models.response.TokenResponse
import io.reactivex.Single
import retrofit2.http.*

interface MessageService {
    @GET("/api/v1/message/")
    fun message(): Single<ListMessageResponse>

    @POST("/api/v1/message/create/")
    fun createMessage(@Body dataMessage: Message): Single<MessageResponse> //передать token

    @PUT("/api/v1/message/update/{id}")
    fun updateMessage(@Path("id") id: String): Single<MessageResponse>

    @DELETE("/api/v1/message/delete/{id}")
    fun deleteMessage(@Path("id") id: String): Single<String>

    @GET("/api/v1/message/addComment/{id}?text=textComment")
    fun addComment(@Path("id") id: String,@Path("textComment") textComment: String): Single<MessageResponse>

    @GET("/api/v1/message/approveMessage/{id}")
    fun approveMessage(@Path("id") id: String): Single<String>

    @GET("/api/v1/message/revertMessage/{id}")
    fun revertMessage(@Path("id") id: String): Single<String>
}