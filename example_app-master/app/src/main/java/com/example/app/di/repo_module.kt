package com.example.app.di

import com.example.app.data.repos.TokenRepositoryImpl
import com.example.app.domain.repository.TokenRepository
import org.koin.dsl.module

val repomodule = module {
    factory<TokenRepository> { TokenRepositoryImpl() }
}