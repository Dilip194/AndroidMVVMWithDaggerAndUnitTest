package com.example.testapplication.network

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.collections.ArrayList

/**
 * @Author: Dilip
 * @Date: 15/10/21
 */
interface APIService {

    /**
     * Get the list of the Acromine from the API
     */
    @GET("/software/acromine/dictionary.py")
    fun callAcromineApi(@Query("sf") sf : String, @Query("lf") lf : String) : Observable<List<ResponseModel>>
}