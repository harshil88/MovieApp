package com.harshilpadsala.movieapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.harshilpadsala.movieapp.R
import com.harshilpadsala.movieapp.adapters.MovieListAdapter
import com.harshilpadsala.movieapp.databinding.FragmentHomeBinding
import com.harshilpadsala.movieapp.vm.HomePageViewModel
import org.koin.android.ext.android.bind
import org.koin.android.ext.android.inject

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    private val viewModel : HomePageViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapterD = MovieListAdapter()
        val adapterT = MovieListAdapter()
        val adapterU = MovieListAdapter()
        binding.apply {
            topRatedMovieRV.adapter = adapterT
            upcomingMovieRV.adapter = adapterU
            discoverMovieRV.adapter = adapterD
        }
        viewModel.response.observe(viewLifecycleOwner, Observer {
           when(viewModel.response.value?.first){
               0 -> adapterT.setFetchedData(viewModel.response.value!!.second)
               1 -> adapterU.setFetchedData(viewModel.response.value!!.second)
               2 -> adapterD.setFetchedData(viewModel.response.value!!.second)
           }
          }
        )
    }
}