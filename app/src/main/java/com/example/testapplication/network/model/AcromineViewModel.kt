package com.example.testapplication.network.model

import androidx.lifecycle.MutableLiveData
import com.example.testapplication.base.BaseViewModel
import com.example.testapplication.network.ResponseModel

/**
 * @Author: Dilip
 * @Date: 16/10/21
 */
class AcromineViewModel : BaseViewModel() {

    private val lf = MutableLiveData<String>()
    private val freq = MutableLiveData<Int>()
    private  val since = MutableLiveData<Int>()
    private val vars = MutableLiveData<AcromineData>()

    fun bind(acromine: Acromine?){
        lf.value = acromine?.lf
        freq.value = acromine?.freq
        since.value = acromine?.since

    }

    fun getLf():MutableLiveData<String>{
        return lf
    }

    fun getFreq(): MutableLiveData<Int> {
        return freq
    }

    fun getSince(): String {
        return since.toString()
    }
}