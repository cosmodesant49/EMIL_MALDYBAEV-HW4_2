package com.geeks.emil_maldybaev_hw4_2.model

import android.icu.text.CaseMap.Title
import java.io.Serializable

data class Task(
    val title: String? = null,
    val desc: String? = null
):Serializable
