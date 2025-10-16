package com.module.core.di

import com.module.common.constant.Conf
import com.module.core.network.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Singleton
    @Provides
    fun provideBaseURL(): String {
        return Conf.BASE_URL
    }

    /**
     * Provide Header interceptor for custom header
     */
    @Provides
    @Singleton
    fun provideHeaderInterceptor(): Interceptor {
        return AuthInterceptor()
    }
    /**
     * Provides LoggingInterceptor for api information
     */
    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    /**
     * Provide Custom Okhttp
     */
    @Provides
    @Singleton
    fun provideOkHttpClient(
        headerInterceptor   : Interceptor,
        loggingInterceptor  : HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .callTimeout(40, TimeUnit.SECONDS)
            .connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .writeTimeout(40, TimeUnit.SECONDS)
            .addInterceptor(headerInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    /**
     * Provides converter factory for retrofit
     */
    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    /**
     * Provides Retrofit
     */
    @Provides
    @Singleton
    fun provideRetrofitClient(
        baseUrl: String,
        okhttpClient : OkHttpClient,
        converterFactory : Converter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okhttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }
}