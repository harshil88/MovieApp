package com.harshilpadsala.movieapp.helper

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.util.Log

object ConnectivityHelper {

    fun getNetworkRequest(): NetworkRequest  = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .addTransportType(NetworkCapabilities.TRANSPORT_WIFI)
            .addTransportType(NetworkCapabilities.TRANSPORT_CELLULAR)
            .build()

     val networkCallback = object : ConnectivityManager.NetworkCallback(){

        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            Log.i("NetworkDebug" , "Network Connection is Available")
        }

        override fun onCapabilitiesChanged(
            network: Network,
            networkCapabilities: NetworkCapabilities
        ) {
            super.onCapabilitiesChanged(network, networkCapabilities)
            val unmetered = networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED)
            Log.i("NetworkDebug" , "Network Changed")
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            Log.i("NetworkDebug" , "Network Connection Lost")
        }

    }




}