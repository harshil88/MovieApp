package com.harshilpadsala.movieapp.services

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.harshilpadsala.movieapp.MainActivity
import com.harshilpadsala.movieapp.R
import com.harshilpadsala.movieapp.constants.Params
import com.harshilpadsala.movieapp.helper.NotificationHelper

class NotificationServiceDE : Service() {

    private fun createNotificationChannel() {

    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        NotificationHelper.createNotificationChannel(this)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        NotificationHelper.createNotification(this)
        return super.onStartCommand(intent, flags, startId)
    }



}