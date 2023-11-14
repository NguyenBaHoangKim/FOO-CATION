package com.example.common.http.apiSearchData

import com.example.model.SearchData
import com.example.model.SearchsData
import retrofit2.Call
import retrofit2.http.GET

interface SearchsDataApi {
    @GET("SearchsData")
    fun getSearchsData(): Call<SearchsData>
}