package com.geektech.retrofit12

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CalculateDao {

    @Query("SELECT * FROM calculateModel")
    fun getAllFromHistory():List<CalculateModel>

    @Insert
    fun addCalculateModel(model: CalculateModel)
}