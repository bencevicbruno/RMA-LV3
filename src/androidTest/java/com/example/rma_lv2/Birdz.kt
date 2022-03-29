package com.example.rma_lv2

import android.app.Application

class Birdz: Application() {

    override fun onCreate() {
        super.onCreate()
        application = this
    }

    companion object{
        lateinit var application: Application
    }
}