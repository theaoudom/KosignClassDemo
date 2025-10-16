package com.module.common.datasource

sealed class Data(var value: String) {

    companion object{
        const val TOKEN = ""
    }
    data object AuthToken: Data(TOKEN)
}