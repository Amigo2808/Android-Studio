package com.amigo.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService:Service() {

    val tag="MyService"

    init {
        Log.d(tag,"Service is Running . . .")
    }
    override fun onBind(intent: Intent?): IBinder? = null
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val data= intent?.getStringExtra("EXTRA_DATA")
        data?.let {
            Log.d(tag,data)
        }
        return START_STICKY
    }

    override fun onDestroy() {
        Log.d(tag,"Service is Destroyed . . .")
    }
}