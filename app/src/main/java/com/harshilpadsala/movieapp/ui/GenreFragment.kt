package com.harshilpadsala.movieapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.harshilpadsala.movieapp.R
import com.harshilpadsala.movieapp.adapters.GenreListAdapter
import com.harshilpadsala.movieapp.databinding.FragmentGenreBinding
import com.harshilpadsala.movieapp.vm.GenrePageViewModel
import com.harshilpadsala.movieapp.vm.HomePageViewModel
import org.koin.android.ext.android.bind
import org.koin.android.ext.android.inject


class GenreFragment : Fragment() {

    private lateinit var binding : FragmentGenreBinding

    private val viewModel : GenrePageViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        binding = FragmentGenreBinding.inflate(
            inflater,
            container,
            false
        )

        binding.viewModel = viewModel

        val genreListAdapter = GenreListAdapter()

        binding.GenreRV.adapter = genreListAdapter

        viewModel.response.observe(viewLifecycleOwner , Observer {
            genreListAdapter.genres = viewModel.response.value!!
            genreListAdapter.notifyDataSetChanged()

            Log.i("Genre" , "Running")

        })

        return binding.root
    }

}