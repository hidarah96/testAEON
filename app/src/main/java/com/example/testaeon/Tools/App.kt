package com.example.testaeon.Tools

import android.content.Context

fun app() = AppComponent.instance

interface AppComponent {
    val context: Context

    companion object {
        lateinit var instance: AppComponent
    }
}