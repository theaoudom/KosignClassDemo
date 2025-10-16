package com.module.features.di

import com.module.features.attendance.domain.repository.AttendanceRepository
import com.module.features.attendance.domain.usecase.AttendanceUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FeatureUseCaseModule {

    @Provides
    @Singleton
    fun provideAttendanceUseCase(
        attendanceRepository: AttendanceRepository
    ) : AttendanceUseCase = AttendanceUseCase(
        attendanceRepository = attendanceRepository
    )

}