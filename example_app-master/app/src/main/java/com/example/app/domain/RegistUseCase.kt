package com.example.app.domain

import com.example.app.data.api.models.User
import com.example.app.data.api.models.response.UserResponse
import com.example.app.data.api.services.LoginService
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.get

class RegistUseCase : KoinComponent {

    operator fun invoke(data: User): Single<UserResponse> =
        get<LoginService>()
            .register(data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterSuccess { user ->  /* ?? логика */ }
}
