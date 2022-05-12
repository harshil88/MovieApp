package com.harshilpadsala.movieapp.adapters

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.net.Uri
import android.text.method.MovementMethod
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.harshilpadsala.movieapp.R
import com.harshilpadsala.movieapp.constants.Endpoint
import com.harshilpadsala.movieapp.data.response.MovieResponse
import com.harshilpadsala.movieapp.databinding.MovieTileBinding




@GlideModule
class MyAppGlideModule : AppGlideModule() {
}

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>() {
    var imageUrl : Uri = Uri.parse("android.resource//com.harshilpadsala.movieapp/" + R.drawable.loaderimage)


    private var movies : List<MovieResponse>  = MutableList(20){
        MovieResponse(
            "",
            "",
            imageUrl.toString(),
            "",
            0.0,
            9,
            listOf()
        )
    }



    private lateinit var binding: MovieTileBinding

    fun setFetchedData(movieList : List<MovieResponse>){
        movies = movieList
        notifyDataSetChanged()
    }

    inner class MovieListViewHolder(private val binding: MovieTileBinding):
            RecyclerView.ViewHolder(binding.root){
        val movieImage = binding.moviePoster
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        binding = MovieTileBinding.inflate(
            inflater,
            parent,
            false
        )
        return MovieListViewHolder(binding)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {

        GlideApp.with(holder.movieImage.context).load(Endpoint.IMAGE_INITIAL_URL +
        movies[position].poster_path).placeholder(R.drawable.loaderimage).into(holder.movieImage)

    }

    override fun getItemCount(): Int {

        return movies.size
    }

}