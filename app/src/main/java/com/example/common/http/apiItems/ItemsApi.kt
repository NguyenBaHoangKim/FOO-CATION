package com.example.common.http.apiItems

import com.example.model.ItemResp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ItemsApi {
    @GET("mystery_item")
    fun getItems(
        @Query("id") id: String
    ): Call<List<ItemResp>>
}