package com.example.myapplication.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.http.apiArtifact.ArtifactManager
import com.example.common.http.apiLocationResp.LocationRespManager
import com.example.common.http.apiSearchData.SearchsDataManager
import com.example.model.Artifact
import com.example.model.Location
import com.example.model.SearchData
import com.example.model.SearchsData
import com.example.myapplication.R
import com.example.myapplication.adapter.SearchAdapter


class SearchActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<SearchData>()

    private var artifactManager = ArtifactManager()
    private var locationManager = LocationRespManager()

    private var m1List = ArrayList<Location>()
    private var m2List = ArrayList<Artifact>()

    private  lateinit var adapter: SearchAdapter
    private var searchsDataManager = SearchsDataManager()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search)

        val btnBack:Button = findViewById(R.id.back)

        btnBack.setOnClickListener {
            finish()
        }
        recyclerView = findViewById(R.id.recyclerView)
        searchView = findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchData()

        addDataToList()

        adapter = SearchAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    private fun  filterList(query: String?){
        if(query != null) {
//            val filteredList = ArrayList<SearchData>()
//            for(i in mList){
//                if(i.title.lowercase(Locale.ROOT).contains(query)){
//                    filteredList.add(i)
//                }
//            }
            val filteredList = mList.filter { data -> data.title.lowercase().contains(query) }
//            val filteredList2 = m2List.filter { data -> data.name.lowercase().contains(query) }

            if(filteredList.isEmpty()){
                Toast.makeText(this, "Hong tìm được rùiiii", Toast.LENGTH_SHORT).show()
            }
//            else if (filteredList2.isEmpty()){
//                Toast.makeText(this, "Hong tìm được rùiiii", Toast.LENGTH_SHORT).show()
//            }
            else{
                adapter.setFilteredList(filteredList)
//                adapter.setFilteredList(filteredList2)
            }
        }
    }

    private fun fetchData() {
        searchsDataManager.getSearchsData({ data: SearchsData ->
            for (dataLocation in data.locations) {
                mList.add(SearchData(dataLocation.id,dataLocation.name,R.drawable.place2,"location"))
            }
            for (dataArtifact in data.artifacts) {
                mList.add(SearchData(dataArtifact.id,dataArtifact.name,R.drawable.place3,"artifact"))
            }
            adapter = SearchAdapter(mList)
            recyclerView.adapter = adapter
        }, { error ->
            println(error)
        })
    }


    private fun addDataToList() {
        mList.add(SearchData("1","Văn Miếu Quốc Tử Giám", R.drawable.place2,"location"))
        mList.add(SearchData("2","Hoàng Thành Thăng Long", R.drawable.place3,"location"))
        mList.add(SearchData("3","Lăng Chủ Tịch Hồ Chí Minh", R.drawable.place4,"location"))
        mList.add(SearchData("4","Nhà Tù Hoả Lò", R.drawable.place5,"location"))
        mList.add(SearchData("5","Văn Miếu Quốc Tử Giám", R.drawable.place1,"location"))
        mList.add(SearchData("6","cổ vật 1", R.drawable.art5,"artifact"))
    }
}