package com.module.core.network

import com.module.core.base.BaseResponse
import com.module.core.data.entity.DataState
import com.module.core.data.entity.ErrorCode
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketException
import java.net.UnknownHostException
import java.util.concurrent.CancellationException

abstract class RemoteDataSource<T> {

    protected abstract suspend fun createCall() : Response<BaseResponse<T>>

    fun asFlow () : Flow<DataState<T>> = flow {
        emit(DataState.Loading)
        try {
            val response = createCall()
            if (response.isSuccessful){
                val body = response.body()?.data
                if (body != null){
                    emit(DataState.Success(body))
                }else{
                    emit(
                        DataState.Error(
                            code = response.code(),
                            message = response.message()
                        )
                    )
                }
            }else{
                val errorJson   = JSONObject(response.errorBody()?.string() ?: "{}")
                val message     = errorJson.optString("message", response.message())
                val code        = errorJson.optInt("status", response.code())
                emit(DataState.Error(code, message))
            }
        }catch (e : Exception){
            when (e) {
                is CancellationException ->
                    return@flow
                is UnknownHostException, is ConnectException, is SocketException ->
                    emit(DataState.Error(ErrorCode.CONNECTION_ERROR, "No internet connection"))
                else ->
                    emit(DataState.Error(ErrorCode.UNKNOWN_ERROR,message = e.message ?: "Unexpected error", ))
            }
        }
    }
}