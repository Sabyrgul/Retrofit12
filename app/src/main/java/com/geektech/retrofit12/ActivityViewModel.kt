package com.geektech.retrofit12

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.Provides
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ActivityViewModel @Inject constructor(private val repository: Repository,
                                            private val preference: Preference): ViewModel() {

    val livedata=MutableLiveData<CalculateModel>()
    fun makeRequest(firstName: String, secondName: String):LiveData<CalculateModel>{
        return repository.makeRequest(firstName,secondName)
    }

    fun setHaveSeenOnBoard() {
        preference.setHaveSeenOnBoarding()
    }

    fun getHaveSeenBoarding():Boolean{
        return preference.getHaveSeenBoarding()
    }

    fun saveData(data:CalculateModel){
        livedata.postValue(data)
    }       
}