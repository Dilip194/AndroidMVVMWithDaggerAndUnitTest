package com.example.testapplication.base

import androidx.lifecycle.ViewModel
import com.example.testapplication.dagger.NetworkModule
import com.example.testapplication.dagger.injection.DaggerViewModelInjector
import com.example.testapplication.dagger.injection.ViewModelInjector
import com.example.testapplication.screen.MainActivityViewModel
import io.reactivex.disposables.Disposable

/**
 * @Author: Dilip
 * @Date: 15/10/21
 */
abstract class BaseViewModel : ViewModel() {

    lateinit var subscription: Disposable

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is MainActivityViewModel -> injector.inject(this)
        }
    }
}