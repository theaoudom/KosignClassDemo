package com.module.features.attendance.domain.model

import com.google.gson.annotations.SerializedName

data class AttendanceResponse(
    val data : List<AttendanceData>
)

data class AttendanceData(
    @SerializedName("name")
    val name: String,
    @SerializedName("image")
    val imagePf: String,
)
