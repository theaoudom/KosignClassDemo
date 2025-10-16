package com.module.core.network

import com.module.common.datasource.Data
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor : Interceptor {

    companion object {
        val SKIP_AUTH_PATHS = setOf(
            "/auth/login",
            "/auth/register",
            "/auth/refresh",
            "/auth/forgot-password",
            "/public/"
        )
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val token   = Data.AuthToken.value

        /**
         * some endpoint that no need token
         */
        if (shouldSkipAuth(originalRequest)){
            return chain.proceed(originalRequest)
        }

        /**
         * add token to header
         */
        val request = if (token.isNotEmpty()){
            originalRequest.newBuilder()
                .header("Authorization", "Bearer $token")
                .build()
        }else {
            originalRequest
        }

        val response = chain.proceed(request)

        return response
    }

    private fun shouldSkipAuth(request: Request): Boolean {
        val url = request.url.toString()
        return SKIP_AUTH_PATHS.any { path ->
            url.contains(path)
        }
    }
}