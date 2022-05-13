package com.harshilpadsala.movieapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.harshilpadsala.movieapp.R
import com.harshilpadsala.movieapp.databinding.FragmentUserAccountBinding
import org.koin.android.ext.android.bind

class UserAccountFragment : Fragment() {

    private lateinit var binding : FragmentUserAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentUserAccountBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }


}