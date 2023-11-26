package com.geeks.emil_maldybaev_hw4_2

import android.app.Application
import androidx.room.Room
import com.geeks.emil_maldybaev_hw4_2.data.local.db.AppDatabase

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }
    companion object{
        lateinit var db: AppDatabase
    }
}