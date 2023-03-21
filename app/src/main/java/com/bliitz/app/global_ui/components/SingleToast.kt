package com.bliitz.app.global_ui.components

import android.content.Context
import android.widget.Toast

enum class SingleToast {

    INSTANCE;

    private var currentToast: Toast? = null
    private var currentMessage: String? = null

    fun show(context: Context?, message: String, duration: Int) {
        if (message == currentMessage) {
            currentToast!!.cancel()
        }
        currentToast = Toast.makeText(context, message, duration)
        currentToast?.show()
        currentMessage = message
    }
}