package com.module.features.di

import com.module.features.attendance.data.api.AttendanceAPI
import com.module.features.attendance.data.service.AttendanceServiceImpl
import com.module.features.attendance.domain.service.AttendanceService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FeatureServiceModule {

    @Provides
    @Singleton
    fun provideAttendanceService(
        attendanceApi: AttendanceAPI
    ) : AttendanceService {
        return AttendanceServiceImpl(
            attendanceApi = attendanceApi
        )
    }
}