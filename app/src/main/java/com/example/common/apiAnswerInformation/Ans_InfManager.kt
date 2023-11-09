package com.example.common.apiSearchData

import android.util.Log
import com.example.common.http.CustomApi
import com.example.model.AnswerInformation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Ans_InfManager {
    private val Ans_InfApi: Ans_InfApi = CustomApi.client()
    fun getAns_Inf(onSuccess: (List<AnswerInformation>) -> Unit, onFailure: (error: String) -> Unit){
        Ans_InfApi.getAns_Inf().enqueue(object : Callback<List<AnswerInformation>?> {
            override fun onResponse(
                call: Call<List<AnswerInformation>?>,
                response: Response<List<AnswerInformation>?>
            ) {
                print(response.body())
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }
            override fun onFailure(call: Call<List<AnswerInformation>?>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}