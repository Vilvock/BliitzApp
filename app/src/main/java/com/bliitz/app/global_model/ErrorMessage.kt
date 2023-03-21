package com.bliitz.app.global_model

import androidx.annotation.Keep

@Keep
data class ErrorMessage(
    val title: String?,
    val message: String
)