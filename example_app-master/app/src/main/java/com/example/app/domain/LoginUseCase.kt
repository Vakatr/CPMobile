package com.example.app.domain

import com.example.app.data.api.models.Login
import com.example.app.data.api.models.response.TokenResponse
import com.example.app.data.api.services.LoginService
import com.example.app.domain.repository.TokenRepository
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.core.KoinComponent
import org.koin.core.get

class LoginUseCase : KoinComponent {

    operator fun invoke(data: Login): Single<TokenResponse> =
        get<LoginService>()
            .login(data)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterSuccess { token ->  get<TokenRepository>().putAccessToken(token.token)}
}
