package com.example.app.presentation.login

import androidx.lifecycle.ViewModel
import com.example.app.data.api.models.Login
import com.example.app.domain.LoginUseCase

class LoginViewModel : ViewModel() {
    private val loginUseCase by lazy { LoginUseCase() }

    fun login(name: String, password: String) =
        loginUseCase(Login(name, password))
}