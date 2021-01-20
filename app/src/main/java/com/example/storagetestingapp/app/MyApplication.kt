package com.example.storagetestingapp.app

import android.app.Application
import android.content.Context

class MyApplication : Application() {

    companion object {

        private lateinit var instance: MyApplication

        fun getApplicationContext(): Context = instance.applicationContext

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}