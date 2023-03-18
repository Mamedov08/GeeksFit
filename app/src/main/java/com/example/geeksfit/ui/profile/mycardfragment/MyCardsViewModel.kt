package com.example.geeksfit.ui.profile.mycardfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.geeksfit.data.remote.model.card.CardBody
import com.example.geeksfit.repository.CardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class MyCardsViewModel  @Inject constructor(private val repository: CardRepository): ViewModel() {

    val allCardsData : MutableLiveData<CardBody> by lazy {
        MutableLiveData<CardBody>()
    }

    fun getMyCard(): LiveData<List<CardBody>>{
        return repository.getMyCard()
    }

}