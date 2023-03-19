package com.geektech.retrofit12

import androidx.room.Database
import androidx.room.RoomDatabase

@Database (
    entities =[CalculateModel::class], version = 1 )

abstract class CalculateDataBase:RoomDatabase() {

    abstract fun getCalculateDao():CalculateDao
}