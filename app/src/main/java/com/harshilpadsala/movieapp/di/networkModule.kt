package com.harshilpadsala.movieapp.di

import com.harshilpadsala.movieapp.constants.Params
import com.harshilpadsala.movieapp.data.remote.GenreService
import com.harshilpadsala.movieapp.data.remote.TMDBMovieFetchService
import com.harshilpadsala.movieapp.vm.GenrePageViewModel
import com.harshilpadsala.movieapp.vm.HomePageViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single { providerRetrofit() }
    single { provideMovieListService(get())}
    single{ provideGenreListService(get())}


    viewModel {
        HomePageViewModel()
    }

    viewModel {
        GenrePageViewModel()
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


