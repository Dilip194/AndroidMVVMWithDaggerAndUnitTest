package com.example.testapplication.screen

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.testapplication.R
import com.example.testapplication.base.BaseViewModel
import com.example.testapplication.network.APIService
import com.example.testapplication.network.ResponseModel
import com.example.testapplication.screen.adapter.AcromineAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * @Author: Dilip
 * @Date: 15/10/21
 */
class MainActivityViewModel : BaseViewModel() {

    @Inject
    lateinit var apiService: APIService

    lateinit var enteredSf : String
    lateinit var enteredLf :String
    val acromineAdapter: AcromineAdapter = AcromineAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    lateinit var responseModel :MutableLiveData<List<ResponseModel>>
    val errorClickListener = View.OnClickListener { callAcromine(enteredSf,enteredLf) }


    fun callAcromine(sf : String, lf : String){
        enteredSf = sf
        enteredLf = lf
        subscription = apiService.callAcromineApi(sf,lf)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveAcromineListStart() }
            .doOnTerminate { onRetrieveAcromineListFinish() }
            .subscribe(
                { result -> onRetrieveAcromineListSuccess(result)
                responseModel.value = result},
                { throwable -> onRetrieveAcromineListError(throwable) }
            )
    }

    private fun onRetrieveAcromineListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveAcromineListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveAcromineListSuccess(result: List<ResponseModel>) {
        acromineAdapter.updatePostList(result)
    }

    private fun onRetrieveAcromineListError(throwable: Throwable) {
        //check the error code and ass the error as per the needs
        errorMessage.value = R.string.post_error
    }
}