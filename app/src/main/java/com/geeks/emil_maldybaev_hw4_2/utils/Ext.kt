package com.geeks.emil_maldybaev_hw4_2.utils

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showToast(msg:String){
    Toast.makeText(requireContext(),msg,Toast.LENGTH_SHORT).show()
}