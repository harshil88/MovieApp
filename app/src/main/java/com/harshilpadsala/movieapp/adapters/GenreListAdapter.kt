package com.harshilpadsala.movieapp.adapters

import android.annotation.SuppressLint
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.harshilpadsala.movieapp.R
import com.harshilpadsala.movieapp.data.response.Genre
import com.harshilpadsala.movieapp.data.response.GenreRes
import com.harshilpadsala.movieapp.databinding.CategoryTileBinding


class GenreListAdapter : RecyclerView.Adapter<GenreListAdapter.GenreListViewHolder>() {
    var imageUrl : Uri = Uri.parse("android.resource//com.harshilpadsala.movieapp/" + R.drawable.loaderimage)


     var genres : List<GenreRes>  = MutableList(20){
        GenreRes(
            -1,
            "No Genre",
        )
    }



    private lateinit var binding: CategoryTileBinding


    inner class GenreListViewHolder(private val binding: CategoryTileBinding):
        RecyclerView.ViewHolder(binding.root){
        val genreName = binding.categoryName

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreListViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        binding = CategoryTileBinding.inflate(
            inflater,
            parent,
            false
        )
        return GenreListViewHolder(binding)
    }

    @SuppressLint("CheckResult")
    override fun onBindViewHolder(holder: GenreListViewHolder , position: Int) {

        holder.genreName.text = genres[position].name
    }

    override fun getItemCount(): Int {
        return genres.size
    }

}