package com.harshilpadsala.movieapp.data.remote

import com.harshilpadsala.movieapp.constants.Endpoint
import com.harshilpadsala.movieapp.data.response.ListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBMovieFetchService {

    @GET(Endpoint.DISCOVER_MOVIES)
    suspend fun discoverMoviesList(
        @Query("api_key") apiKey : String,
    ) : ListResponse

    @GET(Endpoint.TOP_RATED_MOVIES)
    suspend fun topRatedMoviesList(
        @Query("api_key") apiKey : String,
    ) : ListResponse

    @GET(Endpoint.UPCOMING_MOVIES)
    suspend fun upcomingMoviesList(
        @Query("api_key") apiKey : String,
    ) : ListResponse

}