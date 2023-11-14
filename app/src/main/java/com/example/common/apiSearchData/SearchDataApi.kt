package com.example.common.apiSearchData

import com.example.model.SearchData
import retrofit2.Call
import retrofit2.http.GET

interface SearchDataApi {
    @GET("SearchData")
    fun getSearchData(): Call<List<SearchData>>
}