package com.example.geeksfit.di

import android.content.Context
import com.example.geeksfit.BuildConfig
import com.example.geeksfit.data.local.Pref
import com.example.geeksfit.data.remote.ApiService
import com.example.geeksfit.data.remote.CardService
import com.example.geeksfit.data.remote.LoginService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Authenticator
import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieManager
import java.net.CookiePolicy
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {


    @Provides
    @Singleton
    fun getOkhttp(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()
        return okHttpClient
    }

    @Provides
    fun createRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("http://164.92.190.147:8028/api/v1/")
                .client(getOkhttp())
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
    @Provides
    fun provideApi(): ApiService {
        return createRetrofit()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideCardsApi(): CardService {
        return createRetrofit()
            .create(CardService::class.java)
    }

    @Provides
    fun provideLoginApi(): LoginService {
        return createRetrofit()
            .create(LoginService::class.java)
    }

    @Provides
    fun providePrefs(@ApplicationContext context: Context): Pref {
        return Pref(context)
    }


}