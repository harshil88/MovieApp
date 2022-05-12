package com.harshilpadsala.movieapp.data.remote

import com.harshilpadsala.movieapp.constants.Endpoint
import com.harshilpadsala.movieapp.data.response.GenreMainResponse

import retrofit2.http.GET
import retrofit2.http.Query

interface GenreService {

    @GET(Endpoint.GENRE)
    suspend fun genreList(
        @Query("api_key") apiKey : String,
    ) : GenreMainResponse
}