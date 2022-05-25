package com.harshilpadsala.movieapp.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.widget.Toast

class DumbService : Service() {
    override fun onBind(p0: Intent?): IBinder? = null

    override fun onCreate() {
        super.onCreate()
        Toast.makeText(
            this,
            "Voila",
            Toast.LENGTH_SHORT
        ).show()
    }


}