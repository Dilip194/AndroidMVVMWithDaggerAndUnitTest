package com.example.testapplication.network

import com.example.testapplication.network.model.Acromine

/**
 * @Author: Dilip
 * @Date: 15/10/21
 */
data class ResponseModel(
    var sf : String = "",
    var lfs : ArrayList<Acromine>? = null) {
}