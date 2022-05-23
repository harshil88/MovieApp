package com.harshilpadsala.movieapp.adapters


import android.annotation.SuppressLint
import android.graphics.Color
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.harshilpadsala.movieapp.R
import com.harshilpadsala.movieapp.constants.Endpoint
import com.harshilpadsala.movieapp.constants.Params
import com.harshilpadsala.movieapp.data.response.MovieResponse
import com.harshilpadsala.movieapp.databinding.HorizontalMovieTileFileBinding
import com.harshilpadsala.movieapp.databinding.ProgressBarBinding
import kotlinx.coroutines.delay
import okhttp3.internal.notify


class GenreWiseMovieListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()
 {

    var imageUrl : Uri = Uri.parse("android.resource//com.harshilpadsala.movieapp/" + R.drawable.loaderimage)


    private var movies = mutableListOf<MovieResponse?>()
    private lateinit var binding: HorizontalMovieTileFileBinding
     private lateinit var bindingP: ProgressBarBinding
      fun setFetchedData(
         movieList : List<MovieResponse>){

          Log.i("BoDebug" , "Hope it is not interfering")

         val initMoiveSize =  movies.size

         if(movies.isEmpty()){
             movies.addAll(movieList)
             movies.add(null)
             notifyItemRangeInserted(0,21)
         }

         else{
             movies.removeAt(initMoiveSize - 1)
             notifyItemRemoved(initMoiveSize - 1)

             movies.addAll(movieList)
             movies.add(null)
             notifyItemRangeInserted(initMoiveSize - 1 , 21)
         }
    }

     fun reachedBottom(){

         Log.i("BoDebug" , movies.size.toString())
         Log.i("BoDebug" , movies[movies.size - 1].toString())

         movies.removeAt(movies.size -1)
         notifyItemRemoved(movies.size)
     }


     inner class GenreWiseMovieListViewHolder(
         binding: HorizontalMovieTileFileBinding,
         ):
        RecyclerView.ViewHolder(binding.root){
         val movieImage = binding.moviePoster
         val movieName = binding.movieName
     }

      inner class ProgresBarViewHolder(
         binding: ProgressBarBinding
     ):
     RecyclerView.ViewHolder(binding.root){
         val progressIndicator = binding.progressBar
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
           var inflater = LayoutInflater.from(parent.context)

           if (viewType == Params.VIEW_TYPE_NORMAL){
               binding = HorizontalMovieTileFileBinding.inflate(
                   inflater,
                   parent,
                   false
               )
               return GenreWiseMovieListViewHolder(binding)
           }

        else{
               bindingP = ProgressBarBinding.inflate(
                   inflater,
                   parent,
                   false
               )
               return ProgresBarViewHolder(bindingP)
        }


    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is GenreWiseMovieListViewHolder){
            holder.movieName.text = movies[position]!!.original_title
            GlideApp.with(holder.movieImage.context).load(Endpoint.IMAGE_INITIAL_URL +
                    movies[position]!!.poster_path).placeholder(R.drawable.loaderimage).into(holder.movieImage)
        }
    }

     override fun getItemCount(): Int {
         return movies.size
     }

     override fun getItemViewType(position: Int): Int {
         if(movies[position] == null){
             Log.i("HDebug" , "This is the NULL Position + $position")
             return Params.VIEW_TYPE_PROGRESS_BAR
         }
         return Params.VIEW_TYPE_NORMAL
     }

}


