package com.module.features.attendance.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kosign.core.ui.util.errorUtil.getErrorMessage
import com.module.core.data.entity.DataState
import com.module.features.attendance.domain.usecase.AttendanceUseCase
import com.module.features.attendance.presentation.state.AttendanceEvent
import com.module.features.attendance.presentation.state.AttendanceState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AttendanceVm @Inject constructor (
    private val attendanceUseCase: AttendanceUseCase
) : ViewModel() {
    private val _attendanceState = MutableStateFlow(AttendanceState())
    val attendanceState = _attendanceState.asStateFlow()

    private fun onGetAttendance(){
        attendanceUseCase.invoke().onEach { result ->
            when(result){
                is DataState.Loading -> {
                    _attendanceState.value = _attendanceState.value.copy(
                        isLoading = true
                    )
                }
                is DataState.Success -> {
                    _attendanceState.value = _attendanceState.value.copy(
                        isLoading = false,
                        attendance = result.data
                    )
                }
                is DataState.Error -> {
                    _attendanceState.value = _attendanceState.value.copy(
                        isLoading = false,
                        error = getErrorMessage(
                            code = result.code,
                            message = result.message
                        )
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(attendanceEvent: AttendanceEvent){
        when(attendanceEvent){
            is AttendanceEvent.OnGetAttendance -> {
                onGetAttendance()
            }

            is AttendanceEvent.OnSearchChange -> {
                val search = if (attendanceEvent.search.contains("abc")) "" else attendanceEvent.search
                _attendanceState.value = _attendanceState.value.copy(
                    searchText = search
                )
            }

            AttendanceEvent.OnDismissDialog -> {
                _attendanceState.value = _attendanceState.value.copy(
                    error = null
                )
            }
        }
    }
}