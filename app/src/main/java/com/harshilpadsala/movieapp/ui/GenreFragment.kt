package com.harshilpadsala.movieapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.harshilpadsala.movieapp.R
import com.harshilpadsala.movieapp.adapters.GenreListAdapter
import com.harshilpadsala.movieapp.databinding.FragmentGenreBinding
import com.harshilpadsala.movieapp.vm.GenrePageViewModel
import org.koin.android.ext.android.inject


class GenreFragment : Fragment() {

    private lateinit var binding : FragmentGenreBinding

    private val viewModel : GenrePageViewModel by inject()

    @SuppressLint("NotifyDataSetChanged")
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

        val genreListAdapter = GenreListAdapter(
            onItemClicked =  {
                val action = GenreFragmentDirections.actionGenreFragmentToGenreWiseMovieListFragment(it.id)
                findNavController().navigate(action)
            }
        )

        binding.GenreRV.adapter = genreListAdapter
        viewModel.response.observe(viewLifecycleOwner , Observer {
            genreListAdapter.genres = viewModel.response.value!!
            genreListAdapter.notifyDataSetChanged()
        }
        )
        return binding.root
    }

}