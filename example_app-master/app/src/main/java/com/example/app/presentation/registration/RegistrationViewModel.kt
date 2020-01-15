package com.example.app.presentation.registration

import androidx.lifecycle.ViewModel
import com.example.app.data.api.models.User
import com.example.app.domain.RegistUseCase

class RegistrationViewModel : ViewModel() {
    private val RegistUseCase by lazy { RegistUseCase() }

    fun regist(name: String, firstName: String,lastName: String,email: String,gender: String,locale: String,password: String) =
        RegistUseCase(User(name, firstName,lastName,email,gender,locale,password))
}