package com.example.testapplication.utils

import android.text.TextUtils

/**
 * @Author: Dilip
 * @Date: 16/10/21
 */
object Validator {

    fun validateInput(sf : String, lf : String) : Boolean{
        return sf.isNotEmpty() || lf.isNotEmpty()
    }
}