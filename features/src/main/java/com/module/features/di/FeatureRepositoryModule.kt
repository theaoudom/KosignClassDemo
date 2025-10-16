package com.module.features.di

import com.module.features.attendance.data.repository.AttendanceRepositoryImpl
import com.module.features.attendance.domain.repository.AttendanceRepository
import com.module.features.attendance.domain.service.AttendanceService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FeatureRepositoryModule {

    @Provides
    @Singleton
    fun provideAttendanceRepository(
        attendanceService: AttendanceService
    ) : AttendanceRepository {
        return AttendanceRepositoryImpl(
            attendanceService = attendanceService
        )
    }
}