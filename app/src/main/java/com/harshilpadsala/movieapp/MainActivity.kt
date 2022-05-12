package com.harshilpadsala.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.harshilpadsala.movieapp.data.remote.TMDBMovieFetchService
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }
}