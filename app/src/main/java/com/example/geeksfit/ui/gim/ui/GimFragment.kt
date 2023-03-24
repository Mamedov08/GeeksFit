package com.example.geeksfit.ui.gim.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.geeksfit.R
import com.example.geeksfit.core.Status
import com.example.geeksfit.data.remote.model.trainings.ResponseTrainings
import com.example.geeksfit.databinding.FragmentGimBinding
import com.example.geeksfit.ui.gim.adapters.GimAdapter
import com.example.geeksfit.ui.showToast

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GimFragment : Fragment(),GimAdapter.OnItemClick {
    private lateinit var binding: FragmentGimBinding
    private var easyAdapter= GimAdapter()
    private val vm : TrainingsVieModel by viewModels()

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
        easyAdapter.setListener(this)

        setupRecycler()
        getTrainingsEasy()
        getTrainingsContinuing()
        getTrainingsAdvanced()

    }

    private fun getTrainingsAdvanced() {
        vm.getTrainingsAdvanced(1).observe(viewLifecycleOwner){
            easyAdapter.addList(it)
        }
    }

    private fun getTrainingsContinuing() {
       vm.getTrainingsCounting(1).observe(viewLifecycleOwner){
           easyAdapter.addList(it)
       }
    }

    private fun getTrainingsEasy() {

        vm.getTrainingsEasy(1).observe(viewLifecycleOwner){dataResponse ->
           if (dataResponse.isNotEmpty()){
               easyAdapter.addList(dataResponse)
           }
        }

    }

  private fun setupRecycler(){
      binding.rvBegin.adapter = easyAdapter
      binding.rvContinuing.adapter = easyAdapter
      binding.rvAdvanced.adapter = easyAdapter
    }


    override fun onItemClick(list: ResponseTrainings) {
        findNavController().navigate(R.id.detailFragment)
    }


}
