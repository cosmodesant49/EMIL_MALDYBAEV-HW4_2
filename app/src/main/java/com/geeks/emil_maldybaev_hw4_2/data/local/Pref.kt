package com.geeks.emil_maldybaev_hw4_2.data.local

import android.content.Context

class Pref (private val context: Context){
    private val pref = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)

    fun onShowed():Boolean{
        return pref.getBoolean(SHOWED_KEY,false)
    }
    fun onBoardingShow(){
        pref.edit().putBoolean(SHOWED_KEY,true).apply()
    }
    fun rememberName(name:String){
        pref.edit().putString(NAME_KAY,name).apply()

    }
    fun getName():String?{
        return pref.getString(NAME_KAY,"")
    }
    companion object{
        const val SHOWED_KEY="showed.key"
        const val PREF_NAME = "pref.name"
        const val NAME_KAY = "pref.name.key"
    }
}