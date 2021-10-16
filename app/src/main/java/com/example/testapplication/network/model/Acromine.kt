package com.example.testapplication.network.model

/**
 * @Author: Dilip
 * @Date: 15/10/21
 */
data class Acromine(
    var lf : String = "",
    var freq : Int = 0,
    var since : Int = 0,
    var vars : ArrayList<AcromineData>? = null) {
}