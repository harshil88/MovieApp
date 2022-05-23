package com.harshilpadsala.movieapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.harshilpadsala.movieapp.data.response.Genre
import com.harshilpadsala.movieapp.databinding.FragmentGenreBinding
import com.harshilpadsala.movieapp.ui.GenreFragment
import com.harshilpadsala.movieapp.ui.HomeFragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {
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
    }}

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