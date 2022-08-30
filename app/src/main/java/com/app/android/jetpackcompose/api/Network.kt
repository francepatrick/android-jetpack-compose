package com.app.android.jetpackcompose.api

import com.app.android.jetpackcompose.constants.ApiBase
import com.app.android.jetpackcompose.constants.AppVersionName
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object Network {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(client())
            .baseUrl(ApiBase)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }

    @Singleton
    @Provides
    fun client() : OkHttpClient {
        val builder =  OkHttpClient().newBuilder()
            .addInterceptor(authInterceptor())
            .addInterceptor(loggingInterceptor)
            .readTimeout(5, TimeUnit.MINUTES)
            .callTimeout(5, TimeUnit.MINUTES)
        return builder.build()
    }

    @Singleton
    @Provides
    fun authInterceptor() = Interceptor { chain->
        val versionName = AppVersionName
        val newUrl = chain.request().url
            .newBuilder()
            .build()
        val newRequest = chain.request()
            .newBuilder()
            .addHeader("x-user-token", "")
            .addHeader("Content-Type", "application/json" )
            .addHeader("x-mobile-client", "android")
            .addHeader("x-mobile-version", versionName)
            .url(newUrl)
            .build()
        chain.proceed(newRequest)
    }

    private val loggingInterceptor =  HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

}

