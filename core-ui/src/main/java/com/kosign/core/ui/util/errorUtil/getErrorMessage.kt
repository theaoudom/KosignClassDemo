package com.kosign.core.ui.util.errorUtil

import com.kosign.core.ui.util.resource.ResourceUtil
import com.module.core.data.entity.ErrorCode

fun getErrorMessage(code: Int?, message: String?): ResourceUtil {
        return when(code) {
            ErrorCode.CONNECTION_ERROR -> {
                ResourceUtil.DynamicString("No Internet Connection")
            }
            ErrorCode.UNKNOWN_ERROR -> {
                ResourceUtil.DynamicString("Uknown Error")
            }
            else -> {
                ResourceUtil.DynamicString(message.toString())
            }
        }
    }