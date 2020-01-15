package com.example.app.di

import com.example.app.presentation.login.LoginViewModel
import org.koin.dsl.module

val mvvmModule = module {
    factory { LoginViewModel() }
}

