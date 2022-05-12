package com.harshilpadsala.movieapp.di

import com.harshilpadsala.movieapp.adapters.GenreAdapter
import com.harshilpadsala.movieapp.constants.Params
import com.harshilpadsala.movieapp.data.remote.GenreService
import com.harshilpadsala.movieapp.data.remote.TMDBMovieFetchService
import com.harshilpadsala.movieapp.data.response.Genre
import com.harshilpadsala.movieapp.vm.HomePageViewModel
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

val networkModule = module {
    single (named("Retrofit")){ providerRetrofit() }
    single (named("GenreRetrofit")){ providerGenreRetrofit() }
    single { provideMovieListService(get(named("Retrofit"))) }
    single{ provideGenreListService(get(named("GenreRetrofit")))}


    viewModel {
        HomePageViewModel()
    }

}

fun provideMovieListService(retrofit: Retrofit): TMDBMovieFetchService {
    return retrofit.create(TMDBMovieFetchService::class.java)
}

fun provideGenreListService(retrofit: Retrofit): GenreService {
    return retrofit.create(GenreService::class.java)
}

fun providerRetrofit() : Retrofit {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    return Retrofit.Builder().baseUrl(Params.URL).addConverterFactory(
        MoshiConverterFactory.create(moshi)
    ).build()
}

fun providerGenreRetrofit() : Retrofit {
    val moshi = Moshi.Builder().add(GenreAdapter()).build()
    return Retrofit.Builder().baseUrl(Params.URL).addConverterFactory(
        MoshiConverterFactory.create(moshi)
    ).build()
}
