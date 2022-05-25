package com.harshilpadsala.movieapp.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log

class BluetoothReceiver : BroadcastReceiver() {

    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.i("Network" , "At least")
        isNetworkAvailable(p0!!)
    }

    fun isNetworkAvailable(context: Context){
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = cm.activeNetwork
        Log.i("Network" , info.toString() )
    }

}