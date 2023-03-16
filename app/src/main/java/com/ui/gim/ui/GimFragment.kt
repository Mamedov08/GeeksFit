package com.ui.gim.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.geeksfit.R
import com.example.geeksfit.databinding.FragmentGimBinding
import com.ui.gim.adapters.GimAdapter



class GimFragment : Fragment() {
    private lateinit var binding: FragmentGimBinding
    private lateinit var adapter: GimAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGimBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rView.adapter = adapter

        binding.rView.setOnClickListener {
            findNavController().navigate(R.id.detailFragment)
        }

    }
}



