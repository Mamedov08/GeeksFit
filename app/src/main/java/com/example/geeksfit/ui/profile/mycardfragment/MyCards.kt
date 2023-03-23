package com.example.geeksfit.ui.profile.mycardfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.geeksfit.R
import com.example.geeksfit.databinding.FragmentMyCardsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyCards : Fragment() {

    private val vm: MyCardsViewModel by viewModels ()
    lateinit var binding: FragmentMyCardsBinding
    private var cardsAdapter = MyCardsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyCardsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClicker()
        getCardData()
    }

    private fun getCardData() {
        vm.getMyCard().observe(viewLifecycleOwner){
            cardsAdapter.setCardList(it)
        }
    }

    private fun initClicker() {
        binding.btnAddCard.setOnClickListener {
            findNavController().navigate(R.id.addCard)
        }
    }


}
