package com.example.common.http.apiSearchData

import android.util.Log
import com.example.common.http.CustomApi
import com.example.model.SearchData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchDataManager {
    private val searchDataApi: SearchDataApi = CustomApi.client()
    fun getSearchData(onSuccess: (List<SearchData>) -> Unit, onFailure: (error: String) -> Unit){
        searchDataApi.getSearchData().enqueue(object : Callback<List<SearchData>?> {
            override fun onResponse(
                call: Call<List<SearchData>?>,
                response: Response<List<SearchData>?>
            ) {
                print(response.body())
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }

            override fun onFailure(call: Call<List<SearchData>?>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}