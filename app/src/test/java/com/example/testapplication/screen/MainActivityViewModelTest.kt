package com.example.testapplication.screen

import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

/**
 * @Author: Dilip
 * @Date: 16/10/21
 */
class MainActivityViewModelTest {

    lateinit var mainActivityViewModel: MainActivityViewModel

    @Before
    fun setUp() {
        mainActivityViewModel = MainActivityViewModel()
    }

    @Test
    fun callAPiTest() {
        mainActivityViewModel.callAcromine("ams", "")
        var resultValue = mainActivityViewModel.responseModel.getOrWaitValue()
        assertThat(resultValue).isEqualTo(true)
    }
}