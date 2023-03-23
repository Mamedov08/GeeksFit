package com.example.geeksfit.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geeksfit.R
import androidx.navigation.fragment.findNavController
import com.example.geeksfit.databinding.FragmentVerificationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Suppress("UNREACHABLE_CODE")
class VerificationFragment : Fragment() {

    private lateinit var binding: FragmentVerificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
        binding = FragmentVerificationBinding.inflate(layoutInflater)
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

}