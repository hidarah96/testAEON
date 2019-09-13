package com.example.testaeon

import android.app.Application
import com.example.testaeon.Tools.AppComponent
import com.example.testaeon.Tools.Injector

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val injector = Injector(context = this)
        AppComponent.instance = injector

    }


}