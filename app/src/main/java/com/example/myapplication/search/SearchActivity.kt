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
import com.example.common.apiSearchData.Ans_InfManager
import com.example.common.apiSearchData.SearchDataManager
import com.example.model.SearchData
import com.example.myapplication.R
import com.example.myapplication.adapter.SearchAdapter
import java.util.Locale


class SearchActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<SearchData>()
    private  lateinit var adapter: SearchAdapter
    private var searchDataManager = SearchDataManager()


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

//        addDataToList()
//
//        adapter = SearchAdapter(mList)
//        recyclerView.adapter = adapter

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
            val filteredList = ArrayList<SearchData>()
            for(i in mList){
                if(i.title.lowercase(Locale.ROOT).contains(query)){
                    filteredList.add(i)
                }
            }
            if(filteredList.isEmpty()){
                Toast.makeText(this, "Hong tìm được rùiiii", Toast.LENGTH_SHORT).show()
            }
            else{
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun fetchData() {
        searchDataManager.getSearchData({ data: List<SearchData> ->
            for (searchdata in data) {
                mList.add(SearchData(searchdata.title,R.drawable.place2))
                println(searchdata.title)
                println(data.size)
            }
            adapter = SearchAdapter(mList)
            recyclerView.adapter = adapter
        }, { error ->
            println(error)
        })
    }

    private fun addDataToList() {
//        mList.add(SearchData("Văn Miếu Quốc Tử Giám", R.drawable.place2))
//        mList.add(SearchData("Hoàng Thành Thăng Long", R.drawable.place3))
//        mList.add(SearchData("Lăng Chủ Tịch Hồ Chí Minh", R.drawable.place4))
//        mList.add(SearchData("Nhà Tù Hoả Lò", R.drawable.place5))
//        mList.add(SearchData("Văn Miếu Quốc Tử Giám", R.drawable.place1))
    }
}