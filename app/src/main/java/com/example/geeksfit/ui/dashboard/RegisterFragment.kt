package com.example.geeksfit.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.geeksfit.R
import com.example.geeksfit.core.Status
import com.example.geeksfit.data.remote.model.login.LoginBody
import com.example.geeksfit.data.remote.model.login.RegistrationBody
import com.example.geeksfit.databinding.FragmentRegisterBinding
import com.example.geeksfit.ui.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {


    private val vm: RegistrationViewModel by viewModels()
    private lateinit var binding: FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      /*  if (vm.pref.getToken()!= null) {
            findNavController().navigate(R.id.payFragment)
        }
        */

        onClick()

    }

    private fun addRegister() {
        vm.addRegistration(
            RegistrationBody(
                email = binding.RgTextPersonName2.text.toString(),
                password = binding.RgTextPersonName3.text.toString(),
                username = binding.RgTextPersonName1.text.toString()
            )
        ).observe(viewLifecycleOwner) { registerResponse ->
            when (registerResponse.status) {
                Status.SUCCESS ->{
                    vm.saveName(registerResponse.data!!)
                    requireActivity().showToast("Успешно")
                    findNavController().navigate(R.id.loginFragment)
                   /* if (registerResponse.data != null)
                    vm.postLogin(LoginBody(registerResponse.data.username, registerResponse.data.password))
                        .observe(viewLifecycleOwner) { loginResponse ->

                            when(loginResponse.status){
                                Status.SUCCESS ->{
                                    vm.saveTokens(loginResponse.data!!)
                                    requireActivity().showToast("Успешно")
                                    findNavController().navigate(R.id.loginFragment)
                                }
                                Status.LOADING ->{}
                                Status.ERROR ->{
                                    requireActivity().showToast(loginResponse.message!!)
                                }
                            }
                        }*/

                }
                Status.LOADING ->{}
                Status.ERROR ->{
                    requireActivity().showToast(registerResponse.message!!)

                }


            }




        }
    }

    private fun onClick() {
        binding.RgNavigateBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.registerButton1.setOnClickListener {
            if (binding.RgTextPersonName3.text.toString() == binding.RgTextPersonName4.text.toString()) {
                addRegister()
            } else {
                requireActivity().showToast("Пороли не совпадают")
            }

        }
    }
}