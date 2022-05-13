package com.harshilpadsala.movieapp.data.response


import com.squareup.moshi.JsonClass

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

fun getGenres(genreRes : List<GenreRes>) : List<Genre>{

     val genres: MutableList<Genre> = mutableListOf()

    for (currGenreRes in genreRes){
        when(currGenreRes.id){
            28 -> genres.add(Genre(28, "Action" , "https://m.media-amazon.com/images/M/MV5BMDdmMTBiNTYtMDIzNi00NGVlLWIzMDYtZTk3MTQ3NGQxZGEwXkEyXkFqcGdeQXVyMzMwOTU5MDk@._V1_FMjpg_UX1000_.jpg" ))
            12 -> genres.add(Genre(12, "Adventure" , "https://m.media-amazon.com/images/M/MV5BNDE1MGRlNTQtZjc4ZC00MTI0LWEwY2MtODk1YTM2NmFmYTNmXkEyXkFqcGdeQXVyODk4OTc3MTY@._V1_.jpg"))
            16 -> genres.add(Genre(16, "Animation" , "https://m.media-amazon.com/images/M/MV5BMjlmZmI5MDctNDE2YS00YWE0LWE5ZWItZDBhYWQ0NTcxNWRhXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg"))
            35 -> genres.add(Genre(35, "Comedy" , "https://m.media-amazon.com/images/M/MV5BNGQwZjg5YmYtY2VkNC00NzliLTljYTctNzI5NmU3MjE2ODQzXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg"))
            80 -> genres.add(Genre(80, "Crime" , "https://m.media-amazon.com/images/M/MV5BMTg0NjEwNjUxM15BMl5BanBnXkFtZTcwMzk0MjQ5Mg@@._V1_.jpg"))
            99 -> genres.add(Genre(99, "Documentary" , "https://m.media-amazon.com/images/M/MV5BOGUyZDUxZjEtMmIzMC00MzlmLTg4MGItZWJmMzBhZjE0Mjc1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg"))
            18 -> genres.add(Genre(18, "Drama" , "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_.jpg"))
            10751 -> genres.add(Genre(10751, "Family" , "https://m.media-amazon.com/images/M/MV5BMTYyNDg0Njc2Nl5BMl5BanBnXkFtZTYwMDc3NzQ3._V1_FMjpg_UX1000_.jpg"))
            14 -> genres.add(Genre(14, "Fantasy" , "https://m.media-amazon.com/images/M/MV5BN2EyZjM3NzUtNWUzMi00MTgxLWI0NTctMzY4M2VlOTdjZWRiXkEyXkFqcGdeQXVyNDUzOTQ5MjY@._V1_FMjpg_UX1000_.jpg"))
            36 -> genres.add(Genre(36, "History" , "https://m.media-amazon.com/images/M/MV5BMzkyNzQ1Mzc0NV5BMl5BanBnXkFtZTcwODg3MzUzMw@@._V1_.jpg"))
            27 -> genres.add(Genre(27, "Horror" , "https://m.media-amazon.com/images/M/MV5BMTYyOTAxMDA0OF5BMl5BanBnXkFtZTcwNzgwNTc1NA@@._V1_.jpg"))
            10402 -> genres.add(Genre(10402, "Music", "https://m.media-amazon.com/images/M/MV5BYWVlMjUwMzEtMWQyZS00OGFjLWI4ZTQtYWVjYTE0NGE5NzFmXkEyXkFqcGdeQXVyNTE4Mzg5MDY@._V1_.jpg" ))
            10749 -> genres.add(Genre(10749, "Romance" ,"https://m.media-amazon.com/images/M/MV5BMjJjMWRhMzYtMDkxNC00NTA3LWJkZDItZGE4MmIwYjAzYjMxXkEyXkFqcGdeQXVyNTk0ODg1NjY@._V1_FMjpg_UX1000_.jpg" ))
            9648 -> genres.add(Genre(9648, "Mystery" , "https://m.media-amazon.com/images/M/MV5BMTk0MDQ3MzAzOV5BMl5BanBnXkFtZTgwNzU1NzE3MjE@._V1_FMjpg_UX1000_.jpg"))
            878 -> genres.add(Genre(878, "Science Fiction" , "https://m.media-amazon.com/images/M/MV5BNDBiZTNiNjItYWFjNC00Yzc2LWFjMWUtNDAyZmFlZGM0ZWI0XkEyXkFqcGdeQXVyNDQ5MDYzMTk@._V1_.jpg"))
            10770 -> genres.add(Genre(10770, "TV Movie", "https://m.media-amazon.com/images/M/MV5BMTQ5MTcyNDYwMV5BMl5BanBnXkFtZTgwNzMzNzc0MjE@._V1_FMjpg_UX1000_.jpg"))
            53 -> genres.add(Genre(53, "Mystery" , "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX1000_.jpg"))
            10752 -> genres.add(Genre(10752, "War", "https://m.media-amazon.com/images/M/MV5BN2YyZjQ0NTEtNzU5MS00NGZkLTg0MTEtYzJmMWY3MWRhZjM2XkEyXkFqcGdeQXVyMDA4NzMyOA@@._V1_.jpg"))
            37 -> genres.add(Genre(37, "Western" , "https://m.media-amazon.com/images/M/MV5BN2YyZjQ0NTEtNzU5MS00NGZkLTg0MTEtYzJmMWY3MWRhZjM2XkEyXkFqcGdeQXVyMDA4NzMyOA@@._V1_.jpg"))
            else -> throw Exception("Genre Id Not found")
        }
    }
    return genres
}
