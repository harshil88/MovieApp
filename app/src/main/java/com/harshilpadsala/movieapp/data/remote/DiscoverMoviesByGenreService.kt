package com.harshilpadsala.movieapp.data.remote

import com.harshilpadsala.movieapp.constants.Endpoint
import com.harshilpadsala.movieapp.data.response.GenreMainResponse
import com.harshilpadsala.movieapp.data.response.ListResponse
import com.harshilpadsala.movieapp.data.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverMoviesByGenreService {

    @GET(Endpoint.DISCOVER_MOVIE_BY_SINGLE_GENRE)
    suspend fun getSelectedGenre(
        @Query("api_key") apiKey : String,
        @Query("with_geres") genres : String,
    ) : ListResponse

}