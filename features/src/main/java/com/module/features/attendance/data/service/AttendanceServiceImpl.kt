package com.module.features.attendance.data.service

import com.module.core.base.BaseResponse
import com.module.core.data.entity.DataState
import com.module.core.network.RemoteDataSource
import com.module.features.attendance.data.api.AttendanceAPI
import com.module.features.attendance.domain.model.AttendanceResponse
import com.module.features.attendance.domain.service.AttendanceService
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class AttendanceServiceImpl @Inject constructor(
    private val attendanceApi: AttendanceAPI
): AttendanceService{
    override fun getAttendanceList(): Flow<DataState<AttendanceResponse>> {
        val call = object : RemoteDataSource<AttendanceResponse>() {
            override suspend fun createCall(): Response<BaseResponse<AttendanceResponse>> {
                return attendanceApi.getAttendance()
            }
        }
        return call.asFlow()
    }
}