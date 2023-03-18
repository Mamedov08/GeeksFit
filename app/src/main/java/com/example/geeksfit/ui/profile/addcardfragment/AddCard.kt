package com.example.geeksfit.ui.profile.addcardfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.geeksfit.R
import com.example.geeksfit.data.remote.model.card.CardBody
import com.example.geeksfit.data.remote.model.card.CardNumber
import com.example.geeksfit.data.remote.model.card.Cvc
import com.example.geeksfit.data.remote.model.card.MyCard
import com.example.geeksfit.databinding.FragmentAddCardBinding
import com.example.geeksfit.ui.profile.ProfileViewModel
import com.example.geeksfit.ui.showToast
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat

@AndroidEntryPoint
class AddCard : Fragment() {
    private val vm: AddCardViewModel by viewModels()
    lateinit var binding: FragmentAddCardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddCardBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClicker()

    }

    private fun initClicker() {
       binding.btnAdd.setOnClickListener {
           addCard()
       }
    }

    private fun addCard() {
        val dateString = "11/24"
        val dateFormat = SimpleDateFormat("MM/dd")
        val date = dateFormat.parse(dateString)
        val month = date.month + 1 // добавляем 1, так как месяцы в Kotlin начинаются с 0
        val day = date.day


        vm.addCard(
            CardBody(
                cvc = binding.etCvc.text.toString().toInt(),
                card_number = binding.etCardNumber.text.toString(),
                full_name = binding.etCardName.text.toString(),
                month = binding.etExp.text.toString().toInt(),
                year = binding.etExp.text.toString().toInt(),
            )
        ).observe(viewLifecycleOwner) {
            requireActivity().showToast("Карта успешно добавлена")
            findNavController().popBackStack()

        }
    }

}
