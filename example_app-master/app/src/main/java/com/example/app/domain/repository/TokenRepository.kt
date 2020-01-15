package com.example.app.domain.repository
import org.koin.core.KoinComponent

interface TokenRepository {
    fun getAccessToken() : String?
    fun putAccessToken(token: String)
}