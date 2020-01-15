package com.example.app.data.repos

import com.example.app.domain.repository.TokenRepository

class TokenRepositoryImpl : TokenRepository {
    override fun putAccessToken(token: String) {

    }

    override fun getAccessToken(): String? {
        return null
    }

}