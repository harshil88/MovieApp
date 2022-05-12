package com.harshilpadsala.movieapp.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harshilpadsala.movieapp.constants.Params
import com.harshilpadsala.movieapp.data.remote.GenreService
import com.harshilpadsala.movieapp.data.remote.TMDBMovieFetchService
import com.harshilpadsala.movieapp.data.response.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class HomePageViewModel : ViewModel() , KoinComponent{

    private val tmdbMovieFetchService : TMDBMovieFetchService by inject()
    private val genreService : GenreService by inject()

    private val _response = MutableLiveData<Pair<Int, List<MovieResponse>>>()
    val response: LiveData<Pair<Int , List<MovieResponse>>>
    get() = _response




    init {
        Log.i("MovieAppData" , "View Model is Initialized")
        fetchDiscoverMovies()

    }

    fun fetchDiscoverMovies(){
        runCatching {
            viewModelScope.launch(Dispatchers.IO) {
                Log.i("MovieAppData" , "At least it works")
                var receivedData =   tmdbMovieFetchService.discoverMoviesList(
                   Params.API_KEY
               )
                Log.i("MovieAppData" , receivedData.toString())
                _response.postValue(0 to receivedData.results)
            }
        }
    }


    fun fetchTopRatedMovies(){
        runCatching {
            viewModelScope.launch(Dispatchers.IO) {
                Log.i("MovieAppData" , "At least it works")
                var receivedData =   tmdbMovieFetchService.topRatedMoviesList(
                    Params.API_KEY
                )
                Log.i("MovieAppData" , receivedData.toString())
                _response.postValue(1 to receivedData.results)
            }
        }
    }

    fun fetchUpcomingMovies(){
        runCatching {
            viewModelScope.launch(Dispatchers.IO) {
                Log.i("MovieAppData" , "At least it works")
                var receivedData =   tmdbMovieFetchService.upcomingMoviesList(
                    Params.API_KEY
                )
                Log.i("MovieAppData" , receivedData.toString())
                _response.postValue(2 to receivedData.results)
            }
        }
    }
}