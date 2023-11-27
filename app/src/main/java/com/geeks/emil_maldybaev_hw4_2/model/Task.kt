package com.geeks.emil_maldybaev_hw4_2.model

import android.icu.text.CaseMap.Title
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    val title: String? = null,
    val desc: String? = null
) : Serializable
