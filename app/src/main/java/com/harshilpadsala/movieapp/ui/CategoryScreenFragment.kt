package com.harshilpadsala.movieapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.harshilpadsala.movieapp.R
import com.harshilpadsala.movieapp.databinding.FragmentCategoryScreenBinding
import org.koin.android.ext.android.bind


class CategoryScreenFragment : Fragment() {

    private lateinit var binding : FragmentCategoryScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentCategoryScreenBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

}