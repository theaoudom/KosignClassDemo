package com.module.features.attendance.data.api

import com.module.core.base.BaseResponse
import com.module.features.attendance.domain.model.AttendanceResponse
import retrofit2.Response
import retrofit2.http.POST

interface AttendanceAPI {

    @POST("users")
    suspend fun getAttendance() : Response<BaseResponse<AttendanceResponse>>
}
