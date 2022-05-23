package com.harshilpadsala.movieapp.data.response

data class ListResponse(
    val page: Int,
    val results : List<MovieResponse>
)

data class MovieResponse(
    val original_title: String,
    val overview : String,
    val poster_path : String?,
    val release_date : String?,
    val vote_average: Double,
    val vote_count : Long,
    val genre_ids : List<Int>,
)
