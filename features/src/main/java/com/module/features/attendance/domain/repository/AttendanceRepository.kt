package com.module.features.attendance.domain.repository

import com.module.core.data.entity.DataState
import com.module.features.attendance.domain.model.AttendanceResponse
import kotlinx.coroutines.flow.Flow

interface AttendanceRepository {
    fun getAttendanceList() : Flow<DataState<AttendanceResponse>>
}