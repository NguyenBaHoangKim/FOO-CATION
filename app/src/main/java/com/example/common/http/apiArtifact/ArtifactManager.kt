package com.example.common.http.apiArtifact

import android.util.Log
import com.example.common.http.CustomApi
import com.example.model.Artifact
import com.example.model.Location
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArtifactManager {
    private val artifactApi: ArtifactApi = CustomApi.client()
    fun getLocation(onSuccess: (List<Artifact>) -> Unit, onFailure: (error: String) -> Unit){
        artifactApi.getArtifact().enqueue(object : Callback<List<Artifact>?> {
            override fun onResponse(
                call: Call<List<Artifact>?>,
                response: Response<List<Artifact>?>
            ) {
                print(response.body())
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }

            override fun onFailure(call: Call<List<Artifact>?>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}