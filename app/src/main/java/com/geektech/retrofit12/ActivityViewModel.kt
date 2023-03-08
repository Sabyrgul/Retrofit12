package com.geektech.retrofit12

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel: ViewModel() {

    private val test=5
    val repository=Repository()

    fun makeRequest(firstName: String, secondName: String):LiveData<CalculateModel>{
        return repository.makeRequest(firstName,secondName)
    }

    fun getTest(): Int{
        return test
    }
}