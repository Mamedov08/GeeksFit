package com.ui.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.geeksfit.R
import com.example.geeksfit.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.lgbutton1.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
        binding.lgtextView2.setOnClickListener {
            findNavController().navigate(R.id.forgotPasswordFragment)
        }
        binding.LgTextView5.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }
        binding.RgNavigateBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}