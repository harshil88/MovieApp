package com.harshilpadsala.movieapp.ui

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.harshilpadsala.movieapp.adapters.GenreWiseMovieListAdapter
import com.harshilpadsala.movieapp.databinding.FragmentGenreWiseMovieListBinding
import com.harshilpadsala.movieapp.vm.GenreWiseMovieViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class GenreWiseMovieListFragment : Fragment() {

    private lateinit var binding: FragmentGenreWiseMovieListBinding

    private val adapter = GenreWiseMovieListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentGenreWiseMovieListBinding.inflate(
            inflater,
            container,
            false
        )

        binding.genreWiseMoviesRv.adapter = adapter
//        val actionBar = requireActivity().actionBar
//
//        actionBar!!.subtitle = "SUCCEDD"

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         val args = arguments?.let { GenreWiseMovieListFragmentArgs.fromBundle(it).genreId }

        Log.i("HDebug" , args.toString())

        val viewModel: GenreWiseMovieViewModel by viewModel {
            (parametersOf(args))
        }

        binding.viewModel = viewModel

        Log.i("HDebug", "Reaching here")

        initScrollListener(binding.genreWiseMoviesRv , viewModel)

        binding.genreWiseMoviesRv.visibility = View.INVISIBLE

        viewModel.response.observe(viewLifecycleOwner, Observer {

            if(it.isNotEmpty()){
                viewModel.shouldUpdateMoviesList = true
                binding.genreWiseMoviesRv.visibility = View.VISIBLE
                binding.centralProgressBar.visibility = View.GONE

                lifecycleScope.launch {
                    adapter.setFetchedData(it)
                }
                Log.i("RVDebug" , "Live Data Called")
            }

            else{
                Log.i("BoDebug" , "Else is running")
                adapter.reachedBottom()
            }
          }
        )
    }

    private fun initScrollListener(recyclerView: RecyclerView, viewModel: GenreWiseMovieViewModel) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {

                super.onScrollStateChanged(recyclerView, newState)
                if(!recyclerView.canScrollVertically(1)&& newState==RecyclerView.SCROLL_STATE_IDLE){
                    Log.i("RVDebug" , "Scroll Listener called")
                    Log.i("RVDebug" , viewModel.shouldUpdateMoviesList.toString())
                    if(viewModel.shouldUpdateMoviesList){
                        updatePageWhenReachAtTheEnd(viewModel)
                        viewModel.shouldUpdateMoviesList = false
                    }
                }
            }
        }
        )
    }

    private  fun updatePageWhenReachAtTheEnd(viewModel : GenreWiseMovieViewModel){
        viewModel.currPage+=(100)
        viewModel.launchGenreMovies()
    }
}

