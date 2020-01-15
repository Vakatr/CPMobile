package com.example.app.di

import android.content.Context
import com.example.app.BASE_URL
import com.example.app.NETWORK_TIMEOUT
import com.example.app.data.api.services.LoginService
import okhttp3.OkHttpClient
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {
    single { initRetrofit() }
    factory<LoginService> { get<Retrofit>().create(LoginService::class.java) }
}

val globalContext: Context
    get() = GlobalContext.get().koin.rootScope.androidContext()

private fun initRetrofit() = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .client(initOkHttp())
    .build()

private fun initOkHttp() = OkHttpClient.Builder()
    .connectTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
    .readTimeout(NETWORK_TIMEOUT, TimeUnit.SECONDS)
    .build()