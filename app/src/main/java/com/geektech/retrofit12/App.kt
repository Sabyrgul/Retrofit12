package com.geektech.retrofit12

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    companion object{
        lateinit var db:CalculateDataBase
    }

    override fun onCreate() {
        super.onCreate()
        db= Room.databaseBuilder(
            applicationContext,
            CalculateDataBase::class.java,"history-database"
        ).allowMainThreadQueries().build()
    }
}