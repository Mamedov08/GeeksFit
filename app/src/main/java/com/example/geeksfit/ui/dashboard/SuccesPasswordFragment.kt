package com.example.geeksfit.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.geeksfit.R
import com.example.geeksfit.databinding.FragmentSuccesPasswordBinding
import com.google.android.material.button.MaterialButton

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

        val changePasswordTextView: TextView = binding.scTextView
        val successTextView: TextView = binding.scTextView2
        val enterPasswordButton: MaterialButton = binding.scButton

        enterPasswordButton.setOnClickListener {
        findNavController().navigate(R.id.succesPasswordFragment)
        }

        changePasswordTextView.setOnClickListener {
            findNavController().navigate(R.id.succesPasswordFragment)
        }

        successTextView.setOnClickListener {
            findNavController().navigate(R.id.succesPasswordFragment)
        }

        return view
    }
}
