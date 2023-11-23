package com.example.common.http.apiArtifact

import com.example.model.Artifact
import com.example.model.ItemResp
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ItemsApi {
    @GET("locations/{id}/items")
    fun getArtifact(
        @Path("id") id: String
    ): Call<List<ItemResp>>
}