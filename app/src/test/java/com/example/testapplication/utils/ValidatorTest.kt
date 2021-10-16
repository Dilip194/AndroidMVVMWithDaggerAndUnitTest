package com.example.testapplication.utils

import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * @Author: Dilip
 * @Date: 16/10/21
 */
@RunWith(JUnit4::class)
class ValidatorTest{

    @Test
    fun whenInputIsValid(){
        var sf = "ams"
        var lf = ""
        var result = Validator.validateInput(sf,lf)
        assertThat(result)
    }

    @Test
    fun whenInputIsNotValid(){
        var sf = ""
        var lf = ""
        var result = Validator.validateInput(sf,lf)
        assertThat(result)
    }
}