package com.example.common.http.apiArtifact

import com.example.model.Artifact
import com.example.model.Location
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ArtifactApi {
    @GET("locations/{id}/artifacts")
    fun getArtifact(
        @Path("id") id: String
    ): Call<List<Artifact>>
}