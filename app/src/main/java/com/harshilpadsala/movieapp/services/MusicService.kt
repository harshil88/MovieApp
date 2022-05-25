package com.harshilpadsala.movieapp.services

import android.app.Service
import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.widget.Toast
import com.harshilpadsala.movieapp.R

class MusicService : Service() {



    fun getMusicUri(context : Context) : Uri{
        val myUri : Uri = with(context.resources){
            Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(getResourcePackageName(R.raw.bg_music))
                .appendPath(getResourceTypeName(R.raw.bg_music))
                .appendPath(getResourceEntryName(R.raw.bg_music))
                .build()
        }
        return myUri
    }

    private lateinit var mediaPlayer: MediaPlayer

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()

        val myUri = getMusicUri(applicationContext)
        mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(applicationContext, myUri)
        }
        mediaPlayer.prepare()
        mediaPlayer.start()
        Toast.makeText(this,
            "Service creationg successfull" ,
            Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }




}