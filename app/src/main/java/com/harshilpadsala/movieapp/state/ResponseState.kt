package com.harshilpadsala.movieapp.state

sealed class ResponseState {

    object NoInternet : ResponseState()
    object Loading : ResponseState()
    object Success: ResponseState()
    data class Error(val error: String?): ResponseState()

}