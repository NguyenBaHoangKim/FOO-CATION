package com.example.common.http.apiSearchData

import android.util.Log
import com.example.common.http.CustomApi
import com.example.model.SearchsData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchsDataManager {
    private val searchsDataApi: SearchsDataApi = CustomApi.client()
    fun getSearchsData(searchText: String,onSuccess: (SearchsData) -> Unit, onFailure: (error: String) -> Unit){
        searchsDataApi.getSearchsData(searchText).enqueue(object : Callback<SearchsData?> {
            override fun onResponse(
                call: Call<SearchsData?>,
                response: Response<SearchsData?>
            ) {
                print(response.body())
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }
            override fun onFailure(call: Call<SearchsData?>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}