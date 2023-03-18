package com.geektech.retrofit12

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    fun makeRequest(firstName: String, secondName: String):LiveData<CalculateModel>{
        return repository.makeRequest(firstName,secondName)
    }

}