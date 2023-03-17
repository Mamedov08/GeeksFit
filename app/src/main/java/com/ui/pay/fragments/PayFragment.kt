package com.ui.pay.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.geeksfit.databinding.FragmentPayBinding
import com.ui.pay.adapters.PayAdapter
import com.ui.pay.model.Pay

class PayFragment : Fragment() {

    private lateinit var binding: FragmentPayBinding
    private lateinit var adapter: PayAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPayBinding.inflate(layoutInflater, container, false)
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
        val list = ArrayList<Pay>()
        list.apply {

            add(Pay("firstMonth", "accessMonth", "engageMonth"))
        }

        adapter = PayAdapter(list, this::onClickItem)
        binding.onRV.adapter = adapter
    }

    private fun onClickItem(model: Pay) {

    }
}






