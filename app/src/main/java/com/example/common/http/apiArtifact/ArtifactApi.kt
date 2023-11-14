package com.example.common.http.apiArtifact

import com.example.model.Artifact
import com.example.model.Location
import retrofit2.Call
import retrofit2.http.GET

interface ArtifactApi {
    @GET("...")
    fun getArtifact(): Call<List<Artifact>>
}