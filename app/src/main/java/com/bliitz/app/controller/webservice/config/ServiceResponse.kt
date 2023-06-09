package com.bliitz.app.controller.webservice.config

import androidx.annotation.Keep

@Keep
sealed class ServiceResponse<out T> {

    @Keep
    data class Success<out T>(val value: T?) : ServiceResponse<T>()

    @Keep
    sealed class Error: ServiceResponse<Nothing>() {

        @Keep
        data class GenericError(
            val statusCode: Int? = null,
            val error: String? = null,
            val message: String? = null
        ): Error()

        @Keep
        object NetworkError : Error()
    }
}