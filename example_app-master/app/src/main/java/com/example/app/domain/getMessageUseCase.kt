package com.example.app.domain

import com.example.app.data.api.models.response.ListMessageResponse
import com.example.app.data.api.services.MessageService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.get

class getMessageUseCase : KoinComponent {

    operator fun invoke(): Single<ListMessageResponse> =
        get<MessageService>()
            .message()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterSuccess { listMessage ->  /* */ }
}
