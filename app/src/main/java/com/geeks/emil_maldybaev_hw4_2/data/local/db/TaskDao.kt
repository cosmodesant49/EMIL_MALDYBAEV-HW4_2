package com.geeks.emil_maldybaev_hw4_2.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.geeks.emil_maldybaev_hw4_2.model.Task

@Dao
interface TaskDao {

    @Insert
    fun insert(task: Task)

    @Delete
    fun delete(task: Task)

    @Update
    fun update(task: Task)

    @Query("SELECT * FROM task ORDER BY title ASC")
    fun getAll(): List<Task>
}