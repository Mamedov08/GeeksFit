package com.example.geeksfit.ui.pay.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geeksfit.databinding.FragmentCardPayBinding
import com.example.geeksfit.databinding.FragmentPayBinding
import com.example.geeksfit.ui.pay.model.PayCard

class PayCardFragment : Fragment() {

    private lateinit var binding: FragmentCardPayBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardPayBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
    }

    private fun initAdapter() {
        loadData()
    }

    private fun loadData() {
        val list = ArrayList<PayCard>()
        list.apply {

            add(PayCard("accessMonth"))
        }


    }

    private fun onClickItem(model: PayCard) {

    }
}


