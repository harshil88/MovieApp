package com.harshilpadsala.movieapp.vm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harshilpadsala.movieapp.constants.Params
import com.harshilpadsala.movieapp.data.remote.DiscoverMoviesByGenreService
import com.harshilpadsala.movieapp.data.response.MovieResponse
import com.harshilpadsala.movieapp.state.ResponseState
import com.harshilpadsala.movieapp.state.ScrollState
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class GenreWiseMovieViewModel(
    var genreId : Int
) : ViewModel() , KoinComponent {

    private val movieByGenreService : DiscoverMoviesByGenreService by inject()
    private val _response = MutableLiveData<List<MovieResponse>>()

    var state: ResponseState = ResponseState.Loading
     var scrollState: ScrollState = ScrollState.ReachedTop

    val response: LiveData<List<MovieResponse>>
        get() = _response

     var currPage = 0

    init {
        currPage+=1
        launchGenreMovies()
        Log.i("HDebug" , "VMI")
    }

    fun launchGenreMovies(){
        viewModelScope.launch {
            fetchSelectedIdGenre(genreId , currPage)
        }
    }

    private suspend fun fetchSelectedIdGenre(genreId : Int , currPage : Int) {
        viewModelScope.launch {
            runCatching {
                var movies = movieByGenreService.getSelectedGenre(Params.API_KEY, genreId.toString() , currPage.toString())
                _response.postValue(movies.results)
                state = ResponseState.Success
                scrollState = ScrollState.Scrolling
            }.onFailure{
                Log.i("ErDebug", it.toString())
            }
        }
    }
}