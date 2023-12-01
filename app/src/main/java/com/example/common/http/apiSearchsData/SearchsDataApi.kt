package com.example.common.http.apiSearchData

import com.example.model.SearchsData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchsDataApi {
    @GET("Search")
    fun getSearchsData(
        @Query("searchText") searchText: String
    ): Call<SearchsData>
}