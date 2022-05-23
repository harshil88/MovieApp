package com.harshilpadsala.movieapp.di

import androidx.annotation.NonNull
import com.harshilpadsala.movieapp.constants.Params
import com.harshilpadsala.movieapp.data.remote.DiscoverMoviesByGenreService
import com.harshilpadsala.movieapp.data.remote.GenreService
import com.harshilpadsala.movieapp.data.remote.TMDBMovieFetchService
import com.harshilpadsala.movieapp.vm.GenrePageViewModel
import com.harshilpadsala.movieapp.vm.GenreWiseMovieViewModel
import com.harshilpadsala.movieapp.vm.HomePageViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single { providerRetrofit(get()) }
    single { provideMovieListService(get())}
    single{ provideGenreListService(get())}
    single { provideGenreWiseMovieListService(get())}
    single { provideInterceptor()}
    single { provideOkHttpClient(get())}

    viewModel {
        HomePageViewModel()
    }

    viewModel {
        GenrePageViewModel()
    }

    viewModel {
            parameters -> GenreWiseMovieViewModel(genreId = parameters.get<Int>() as Int)
    }


}

fun provideMovieListService(retrofit: Retrofit): TMDBMovieFetchService {
    return retrofit.create(TMDBMovieFetchService::class.java)
}

fun provideGenreListService(retrofit: Retrofit): GenreService {
    return retrofit.create(GenreService::class.java)
}

fun provideGenreWiseMovieListService(retrofit: Retrofit): DiscoverMoviesByGenreService {
    return retrofit.create(DiscoverMoviesByGenreService::class.java)
}

fun providerRetrofit(okHttpClient: OkHttpClient) : Retrofit {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    return Retrofit.Builder().baseUrl(Params.URL).client(okHttpClient).addConverterFactory(
        MoshiConverterFactory.create(moshi)
    ).build()
}

fun provideInterceptor() : HttpLoggingInterceptor{
    val httpLoggingInterceptor : HttpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return httpLoggingInterceptor
}

fun provideOkHttpClient(
    httpLoggingInterceptor: HttpLoggingInterceptor
): OkHttpClient {
    return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
}


