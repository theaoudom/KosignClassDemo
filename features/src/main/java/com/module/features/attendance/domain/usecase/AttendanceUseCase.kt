package com.module.features.attendance.domain.usecase

import com.module.core.data.entity.DataState
import com.module.features.attendance.domain.model.AttendanceResponse
import com.module.features.attendance.domain.repository.AttendanceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AttendanceUseCase @Inject constructor(
    private val attendanceRepository: AttendanceRepository
) {

    operator fun invoke(): Flow<DataState<AttendanceResponse>> = flow {
        emit(DataState.Loading)
        attendanceRepository.getAttendanceList().collect {
            it.let {
                if (it is DataState.Success){
                    emit(DataState.Success(it.data))
                }
                if (it is DataState.Error){
                    emit(DataState.Error(it.code,it.message))
                }
            }
        }
    }

}