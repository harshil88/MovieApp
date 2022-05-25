package com.harshilpadsala.movieapp.state

sealed class ScrollState{

    object Scrolling : ScrollState()
    object ReachedTop : ScrollState()
    object ReachedBottom: ScrollState()
    object EndOfTheList: ScrollState()

}