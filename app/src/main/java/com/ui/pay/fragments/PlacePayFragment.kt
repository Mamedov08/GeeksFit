package com.ui.pay.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.geeksfit.R
import com.example.geeksfit.databinding.FragmentPlacePayBinding
import com.ui.pay.adapters.PlacePayAdapter
import com.ui.pay.model.PayPal


class PlacePayFragment : Fragment() {
    private lateinit var binding: FragmentPlacePayBinding

    private lateinit var adapter: PlacePayAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment paycard.image?.let { binding.imageCardP.setImageResource(it) }
        binding = FragmentPlacePayBinding.inflate(inflater, container, false)
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
        val list = ArrayList<PayPal>()
        list.apply {

            add(PayPal(R.drawable.image, "@string/BayO"))
        }

               binding.rcView.adapter = adapter
    }
    private fun onClickItem(model: PayPal) {

    }
}


