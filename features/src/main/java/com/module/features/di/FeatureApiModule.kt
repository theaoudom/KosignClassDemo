package com.module.features.di

import com.module.features.attendance.data.api.AttendanceAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FeatureApiModule {

    @Provides
    @Singleton
    fun provideAttendanceApi(retrofit: Retrofit) : AttendanceAPI {
        return retrofit.create(AttendanceAPI::class.java)
    }
}