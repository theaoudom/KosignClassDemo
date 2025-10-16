package com.module.core.data.entity

/**
 * Data state for processing api response Loading, Success and Error
 */
sealed class DataState<out R> {
    data class Success<out T> (val data: T) : DataState<T> ()
    data class Error(val code: Int? = null, val message: String? = null) : DataState<Nothing> ()
    data object Loading : DataState<Nothing> ()
}