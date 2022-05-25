package com.harshilpadsala.movieapp

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.harshilpadsala.movieapp.constants.Params
import com.harshilpadsala.movieapp.helper.ConnectivityHelper
import com.harshilpadsala.movieapp.receiver.BluetoothReceiver
import com.harshilpadsala.movieapp.services.DumbService
import com.harshilpadsala.movieapp.services.MusicService
import com.harshilpadsala.movieapp.services.NotificationServiceDE
import com.harshilpadsala.movieapp.ui.MusicPlayDialogFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(),
MusicPlayDialogFragment.MusicPlayDialogListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val chipNavigationBar = findViewById<BottomNavigationView>(R.id.mainBottomNav)
        NavigationUI.setupWithNavController(
            chipNavigationBar,
            navController,)
        navSetup(navController, chipNavigationBar)
        val intent = Intent(this, NotificationServiceDE::class.java)
        startService(intent)
        val intentF = IntentFilter()
        val connectivityManager = getSystemService(ConnectivityManager::class.java)
        connectivityManager.requestNetwork(
            ConnectivityHelper.getNetworkRequest(),
            ConnectivityHelper.networkCallback,
        )
    }


  private fun showDialog(){
         val dialogFragment = MusicPlayDialogFragment()
        lifecycleScope.launch {
            delay(20000)
            dialogFragment.show(supportFragmentManager, "game")
        }
    }

    override fun onDialogPositiveClick(dialogFragment: DialogFragment) {
    }


    override fun onDialogNegativeClick(dialogFragment: DialogFragment) {
        Intent(this, MusicService::class.java).also {
                intent -> startService(intent)
        }
    }
}

private fun navSetup(nav : NavController , bottomNav : BottomNavigationView){
    nav.addOnDestinationChangedListener{
        _, dest , _ ->
        when(dest.id){
            R.id.homeFragment -> showBottomNav(bottomNav)
            R.id.genreFragment -> showBottomNav(bottomNav)
            R.id.genreWiseMovieListFragment -> hideBottomNav(bottomNav)
            else -> hideBottomNav(bottomNav)
        }
    }
}

private fun showBottomNav(bottomNav : BottomNavigationView) {
    bottomNav.visibility = View.VISIBLE
}

private fun hideBottomNav(bottomNav : BottomNavigationView) {
    bottomNav.visibility = View.GONE
}



