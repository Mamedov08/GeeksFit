package com.example.geeksfit.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.geeksfit.R
import com.example.geeksfit.databinding.FragmentVerificationBinding


@Suppress("UNREACHABLE_CODE")
class VerificationFragment : Fragment() {
    private lateinit var binding: FragmentVerificationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentVerificationBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return (binding.root)
    }
}
