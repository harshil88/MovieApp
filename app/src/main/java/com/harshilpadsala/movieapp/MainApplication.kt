package com.harshilpadsala.movieapp

import android.app.Application
import com.harshilpadsala.movieapp.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {

            //What is the purpose of this android logger
            androidLogger()
            //What is the purpose of this android context
            androidContext(this@MainApplication)
            modules(networkModule)
        }
    }

}