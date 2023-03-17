package com.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.geeksfit.R
import com.example.geeksfit.databinding.FragmentSuccesPasswordBinding

class SuccessPasswordFragment : Fragment() {

    private var _binding: FragmentSuccesPasswordBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuccesPasswordBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.scButton.setOnClickListener {
            findNavController().navigate(R.id.succesPasswordFragment)
        }

        binding.scTextView2.setOnClickListener {
            findNavController().navigate(R.id.succesPasswordFragment)
        }

        binding.scTextView.setOnClickListener {
            findNavController().navigate(R.id.succesPasswordFragment)
        }

        return view
    }
}
