package com.example.myapplication.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.http.apiArtifact.ArtifactManager
import com.example.common.http.apiLocationResp.LocationRespManager
import com.example.common.http.apiSearchData.SearchsDataManager
import com.example.model.LocationResp
import com.example.model.SearchsData
import com.example.myapplication.R
import com.example.myapplication.adapter.SearchAdapter


class SearchActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var searchView: SearchView
    private lateinit var mList : SearchsData

    private var artifactManager = ArtifactManager()
    private var locationManager = LocationRespManager()

    private lateinit var btn: Button

    private  lateinit var adapter: SearchAdapter
    private var searchsDataManager = SearchsDataManager()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search)

        val btnBack:Button = findViewById(R.id.back)

        btnBack.setOnClickListener {
            finish()
            overridePendingTransition(androidx.transition.R.anim.abc_fade_in, androidx.transition.R.anim.abc_fade_out);
        }
        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

//        fetchData()
//
//        addDataToList()
//        adapter = SearchAdapter(mList)
//        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                getSearchData(newText)
//                filterList(newText)
                return true
            }
        })
    }

//    private fun  filterList(query: String?){
//        if(query != null) {
//            val filteredList = mList.filter { data -> data.title.lowercase().contains(query) }
//            if(filteredList.isEmpty()){
//                Toast.makeText(this, "Hong tìm được rùiiii", Toast.LENGTH_SHORT).show()
//            }
//            else{
//                adapter.setFilteredList(filteredList)
//            }
//        }
//    }

    private fun fetchData() {
        locationManager.getLocationList({ data: List<LocationResp> ->
            for (dataLocation in data) {
//                mList.add(SearchData(dataLocation.id,dataLocation.name,dataLocation.image.data.toBitMap(),"location"))
            }
            adapter = SearchAdapter(mList)
            recyclerView.adapter = adapter
        }, { error ->
            println(error)
        })
    }

    private fun getSearchData(searchData: String) {
        searchsDataManager.getSearchsData(searchData,{ data: SearchsData ->
            
        }, { error ->
            println(error)
        })
    }


    private fun addDataToList() {
//        mList.add(SearchData("1","Văn Miếu Quốc Tử Giám", R.drawable.place2,"location"))
//        mList.add(SearchData("2","Hoàng Thành Thăng Long", R.drawable.place3,"location"))
//        mList.add(SearchData("3","Lăng Chủ Tịch Hồ Chí Minh", R.drawable.place4,"location"))
//        mList.add(SearchData("4","Nhà Tù Hoả Lò", R.drawable.place5,"location"))
//        mList.add(SearchData("5","Văn Miếu Quốc Tử Giám", R.drawable.place1,"location"))
//        mList.add(SearchData("6","cổ vật 1", R.drawable.art5,"artifact"))
    }
}