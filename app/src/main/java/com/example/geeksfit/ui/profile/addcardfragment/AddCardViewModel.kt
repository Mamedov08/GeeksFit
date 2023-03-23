package com.example.geeksfit.ui.profile.addcardfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.geeksfit.data.remote.model.card.CardBody
import com.example.geeksfit.data.remote.model.card.MyCard
import com.example.geeksfit.repository.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddCardViewModel  @Inject constructor(private val repository: CardRepository) : ViewModel() {
    fun addCard(card: CardBody): LiveData<CardBody> {
        return repository.addMyCard(card = card)
    }

}