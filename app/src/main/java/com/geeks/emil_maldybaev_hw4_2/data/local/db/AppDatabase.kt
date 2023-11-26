package com.geeks.emil_maldybaev_hw4_2.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geeks.emil_maldybaev_hw4_2.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}