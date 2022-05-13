package com.harshilpadsala.movieapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        val chipNavigationBar = findViewById<ChipNavigationBar>(R.id.mainBottomNav)

        chipNavigationBar.setOnItemSelectedListener {

            navController.popBackStack()

            navController.navigate(it)
                navController.navigate(R.id.action_homeFragment_to_categoryScreenFragment)
        }

        supportActionBar?.hide()

    }



}