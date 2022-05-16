package com.harshilpadsala.movieapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.constraintlayout.widget.ConstraintSet
import androidx.fragment.app.Fragment
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

//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController

        val chipNavigationBar = findViewById<BottomNavigationView>(R.id.mainBottomNav)


        val homeFragment = HomeFragment()
        val genreFragment = GenreFragment()
        val fm = supportFragmentManager

        fm.beginTransaction().add(R.id.main_container, homeFragment , "1").commit()
        fm.beginTransaction().add(R.id.main_container, genreFragment , "2").hide(genreFragment).commit()

        chipNavigationBar.setOnItemSelectedListener {
            if (it.itemId==R.id.genreFragment){
                Log.i("GenreDIS" , "Go to Genres")
                fm.beginTransaction().hide(homeFragment).show(genreFragment).commit()
                 true
            }

            else{ Log.i("GenreDIS" , "Go to Home")
                fm.beginTransaction().hide(genreFragment).show(homeFragment).commit()
                true
            }
        }

    }}