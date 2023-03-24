package com.example.geeksfit.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.geeksfit.R
import com.example.geeksfit.core.Status
import com.example.geeksfit.data.remote.model.login.LoginBody
import com.example.geeksfit.data.remote.model.login.RegistrationBody
import com.example.geeksfit.databinding.FragmentLoginBinding
import com.example.geeksfit.ui.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {


    private val vm: RegistrationViewModel by viewModels()
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClicker()


    }

    private fun getLogin() {
        vm.postLogin(
            LoginBody(
                password = binding.LgTextPersonName2.text.toString(),
                username = binding.LgTextPersonName1.text.toString()
            )
        )
            .observe(viewLifecycleOwner) { loginResponse ->

                when (loginResponse.status) {
                    Status.SUCCESS -> {
                        vm.saveTokens(loginResponse.data!!)
                        requireActivity().showToast("Успешно")
                        findNavController().navigate(R.id.payFragment)
                    }
                    Status.LOADING -> {}
                    Status.ERROR -> {
                        requireActivity().showToast(loginResponse.message!!)
                    }
                }
            }
    }


    private fun initClicker() {
        binding.lgbutton1.setOnClickListener {
            getLogin()
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