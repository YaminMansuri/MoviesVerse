package com.ymistudios.movieverse.di.module

import com.ymistudios.movieverse.di.DiConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetModule {

    @Provides
    @Singleton
    fun provideClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    }

    @Provides
    @Singleton
    @Named(DiConstants.API_KEY)
    fun provideApiKey(): String {
        return "bb777fd9"
    }

    @Provides
    @Singleton
    @Named(DiConstants.BASE_URL)
    fun provideBaseUrl(): String {
        return "http://www.omdbapi.com/?"
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        @Named(DiConstants.BASE_URL) baseUrl: String,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}