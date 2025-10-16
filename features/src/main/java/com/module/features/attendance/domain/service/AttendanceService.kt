package com.module.features.attendance.domain.service

import com.module.core.data.entity.DataState
import com.module.features.attendance.domain.model.AttendanceResponse
import kotlinx.coroutines.flow.Flow

interface AttendanceService {

    fun getAttendanceList() : Flow<DataState<AttendanceResponse>>
}