package com.harshilpadsala.movieapp.vm

import android.text.PrecomputedText
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.harshilpadsala.movieapp.constants.Params
import com.harshilpadsala.movieapp.data.remote.GenreService
import com.harshilpadsala.movieapp.data.response.GenreRes
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject

class GenrePageViewModel : ViewModel() , KoinComponent {

    private val genreService : GenreService by inject()

    private val _response = MutableLiveData<List<GenreRes>>()
    val response: LiveData< List<GenreRes>>
        get() = _response

    private var genreFetched = false

    init {
        if (!genreFetched){
            viewModelScope.launch { fetchAllGenres() }
        }
    }


    private suspend fun fetchAllGenres() {
        viewModelScope.launch {
          runCatching {
              var genres =  genreService.genreList(Params.API_KEY)
              _response.postValue(genres.genres)
              genreFetched = true
          }.onFailure {
              it.message
          }
        }
    }
}