package com.harshilpadsala.movieapp.data.response


import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GenreMainResponse(
    val genres : List<Genre>
)

data class GenreRes(
    val id: Int,
    val name: String,
)

data class Genre(
    val id: Int,
    val name: String,
    val imageUrl: String,
)
