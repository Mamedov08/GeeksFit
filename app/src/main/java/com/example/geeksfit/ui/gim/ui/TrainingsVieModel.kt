package com.example.geeksfit.ui.gim.ui


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.geeksfit.core.Resource
import com.example.geeksfit.data.remote.model.trainings.ResponseTrainings
import com.example.geeksfit.repository.TrainingsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TrainingsVieModel @Inject constructor(private val repository: TrainingsRepository):ViewModel() {

    fun getTrainingsEasy(page: Int): LiveData<List<ResponseTrainings>> {
        return repository.getTrainingsEasy(page = page)
    }

   fun getTrainingsAdvanced(page: Int): LiveData<List<ResponseTrainings>> {
        return repository.getTrainingsAdvanced(page = page)
    }

    fun getTrainingsCounting(page: Int): LiveData<List<ResponseTrainings>> {
        return repository.getTrainingsCounting(page = page)
    }



}