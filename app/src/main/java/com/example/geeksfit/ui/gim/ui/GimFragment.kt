package com.example.geeksfit.ui.gim.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.geeksfit.R
import com.example.geeksfit.databinding.FragmentGimBinding
import com.example.geeksfit.ui.gim.adapters.GimAdapter
import com.example.geeksfit.ui.gim.model.GimModel


class GimFragment : Fragment() {
    private lateinit var binding: FragmentGimBinding
    private lateinit var adapter: GimAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentGimBinding.inflate(layoutInflater, container, false)
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
        val list = ArrayList<GimModel>()
        list.apply {
//
//            add(GimModel(
//                R.string.fit_first (
//                R.drawable.img, R.string.n_hand,
//                R.drawable.img_1,R.string.a_hand,
//                R.drawable.img_2,R.string.b_hand,
//                R.drawable.img_3,R.string.c_hand,
//                R.drawable.img_4,R.string.e_hand)
//
//                R.string.fit_second (
//                R.drawable.img, R.string.p_hand,
//                R.drawable.img_1,R.string.f_hand,
//                R.drawable.img_2,R.string.g_hand,
//                R.drawable.img_3,R.string.h_hand,
//                R.drawable.img_4,R.string.i_hand)
//
//                R.string.fit_third(
//                R.drawable.img, R.string.d_hand,
//                R.drawable.img_1,R.string.j_hand,
//                R.drawable.img_2,R.string.k_hand,
//                R.drawable.img_3,R.string.l_hand,
//                R.drawable.img_4,R.string.m_hand)
//            ))

        }
        adapter = GimAdapter(list, this::onClickItem)
        binding.rView.adapter = adapter
    }

    private fun onClickItem(model: GimModel) {

    }

}
