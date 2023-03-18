package com.example.geeksfit.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.geeksfit.data.remote.model.personalinform.PersonalInform
import com.example.geeksfit.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    fun getPersonalInform():LiveData<PersonalInform>{
        return repository.getPersonalInform()
    }
}