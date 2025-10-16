package com.module.core.base

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("status")
    val status: Boolean? = null,

    @SerializedName("message")
    val message: String? = null,

    @SerializedName("payload")
    val data: T? = null,

    @SerializedName("date")
    val date: String? = null
)
