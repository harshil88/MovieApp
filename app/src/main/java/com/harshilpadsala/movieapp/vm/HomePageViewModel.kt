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
import kotlinx.coroutines.*
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.lang.Exception

class HomePageViewModel : ViewModel() , KoinComponent{

    private val tmdbMovieFetchService : TMDBMovieFetchService by inject()

    private val _response = MutableLiveData<Pair<Int, List<MovieResponse>>>()
    val response: LiveData<Pair<Int , List<MovieResponse>>>
    get() = _response


    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        Exception("Something Happened")
    }

    init {
        viewModelScope.launch {launchTheRequests()}
    }

    private suspend fun launchTheRequests() {
      val parentJob =   supervisorScope {
            fetchDiscoverMovies()
            fetchUpcomingMovies()
            fetchTopRatedMovies()
        }
    }

   private suspend fun fetchDiscoverMovies(){
        runCatching {
           var receivedData =  viewModelScope.async(exceptionHandler) {
              withContext(Dispatchers.IO){
                  tmdbMovieFetchService.discoverMoviesList(
                      Params.API_KEY
               )
              }
            }
            _response.postValue(0 to receivedData.await().results)
        }
    }

  private suspend  fun fetchTopRatedMovies(){
        runCatching {
           var receivedData =  viewModelScope.async(exceptionHandler) {
               withContext(Dispatchers.IO){
                   tmdbMovieFetchService.topRatedMoviesList(
                       Params.API_KEY
                   )
               }
            }
            _response.postValue(1 to receivedData.await().results)
        }
    }

   private suspend fun fetchUpcomingMovies(){
        runCatching {
            var receivedData =   viewModelScope.async(exceptionHandler) {
                withContext(Dispatchers.IO){
                    tmdbMovieFetchService.upcomingMoviesList(
                        Params.API_KEY
                    )
                }
            }
            _response.postValue(2 to receivedData.await().results)
        }
    }
}