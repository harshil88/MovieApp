package com.harshilpadsala.movieapp.adapters


import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harshilpadsala.movieapp.R
import com.harshilpadsala.movieapp.constants.Endpoint
import com.harshilpadsala.movieapp.data.response.MovieResponse
import com.harshilpadsala.movieapp.databinding.HorizontalMovieTileFileBinding


class GenreWiseMovieListAdapter : RecyclerView.Adapter<GenreWiseMovieListAdapter.GenreWiseMovieListViewHolder>() {
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



    private lateinit var binding: HorizontalMovieTileFileBinding

    fun setFetchedData(movieList : List<MovieResponse>){
        movies = movieList
        notifyDataSetChanged()
    }

    inner class GenreWiseMovieListViewHolder(private val binding: HorizontalMovieTileFileBinding):
        RecyclerView.ViewHolder(binding.root){
        val movieImage = binding.moviePoster
        val movieName = binding.movieName
        val movieGenreChips = binding.genreChips
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreWiseMovieListViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        binding = HorizontalMovieTileFileBinding.inflate(
            inflater,
            parent,
            false
        )
        return GenreWiseMovieListViewHolder(binding)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: GenreWiseMovieListViewHolder, position: Int) {

        holder.movieName.text = movies[position].original_title

        GlideApp.with(holder.movieImage.context).load(Endpoint.IMAGE_INITIAL_URL +
                movies[position].poster_path).placeholder(R.drawable.loaderimage).into(holder.movieImage)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}