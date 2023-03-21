package com.bliitz.app

import android.app.Application
import android.content.res.Resources
import com.bliitz.app.controller.webservice.config.RetrofitServices

class GlobalApplication(): Application() {

    override fun onCreate() {
        super.onCreate()

        RetrofitServices.init(this)
    }

    fun getAppResources(): Resources? {
        return resources
    }

}