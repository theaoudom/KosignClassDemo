package com.module.features.attendance.data.repository

import com.module.core.data.entity.DataState
import com.module.features.attendance.domain.model.AttendanceResponse
import com.module.features.attendance.domain.repository.AttendanceRepository
import com.module.features.attendance.domain.service.AttendanceService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AttendanceRepositoryImpl @Inject constructor(
    private val attendanceService: AttendanceService
): AttendanceRepository {
    override fun getAttendanceList(): Flow<DataState<AttendanceResponse>> {
        return attendanceService.getAttendanceList()
    }
}