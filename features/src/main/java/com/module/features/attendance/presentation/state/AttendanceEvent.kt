package com.module.features.attendance.presentation.state

sealed class AttendanceEvent {
    data object OnGetAttendance : AttendanceEvent()
    data object OnDismissDialog : AttendanceEvent()
    data class OnSearchChange(val search: String) : AttendanceEvent()
}