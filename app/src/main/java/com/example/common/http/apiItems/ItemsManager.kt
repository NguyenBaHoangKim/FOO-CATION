package com.example.common.http.apiItems

import android.util.Log
import com.example.common.http.CustomApi
import com.example.model.ItemResp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemsManager {
    private val itemsApi: ItemsApi = CustomApi.client()
    fun getItemsWithLocationId(locationId: String, onSuccess: (List<ItemResp>) -> Unit, onFailure: (error: String) -> Unit){
        itemsApi.getItems(locationId).enqueue(object : Callback<List<ItemResp>?> {
            override fun onResponse(
                call: Call<List<ItemResp>?>,
                response: Response<List<ItemResp>?>
            ) {
                println(response.body())
                println("goi dc 5 cai anh ruii")
                val responseBody = response.body() ?: return
                onSuccess(responseBody)
            }

            override fun onFailure(call: Call<List<ItemResp>?>, t: Throwable) {
                onFailure(t.message!!)
                Log.d("MainActivity", "onFailure: " + t.message)
            }
        })
    }
}