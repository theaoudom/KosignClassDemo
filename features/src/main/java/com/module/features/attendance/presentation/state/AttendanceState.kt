package com.module.features.attendance.presentation.state

import com.kosign.core.ui.util.resource.ResourceUtil
import com.module.core.data.entity.Status
import com.module.features.attendance.domain.model.AttendanceResponse

data class AttendanceState(
    val status      : Status? = null,
    val isLoading   : Boolean = false,
    val data        : AttendanceResponse? = null,
    val error       : ResourceUtil? = null
)
