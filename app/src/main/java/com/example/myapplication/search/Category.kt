package com.example.myapplication.search

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.model.SearchData
import com.example.myapplication.R
import com.example.myapplication.adapter.SearchCategoryAdapter
import com.google.android.material.card.MaterialCardView
import java.util.Locale


class Category  : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<SearchData>()
    private  lateinit var adapter: SearchCategoryAdapter
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

//        val btn:MaterialCardView = recyclerView.findViewById(R.id.btn_infomation)

        val extras : Bundle? = intent.extras
        if (extras != null) {
            val id : Any? = extras.get("key")
            println(id)
            when (id){
                R.id.location -> addDataLocation()
                R.id.history -> addDataHistory()
                R.id.literature -> addDataLiterature()
                R.id.artifact -> addDataArtifact()
                R.id.art -> addDataArt()
                R.id.park -> addDataPark()
            }
        }
//        addDataToList()
        adapter = SearchCategoryAdapter(mList)
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

    private fun addDataPark() {
//        mList.add(SearchData("Công Viên Nước Hồ Tây", R.drawable.park1))
//        mList.add(SearchData("Công Viên Thống Nhất", R.drawable.park2))
//        mList.add(SearchData("Công Viên Yên Sở", R.drawable.park3))
//        mList.add(SearchData("VinWonders Hà Nội", R.drawable.park4))
//        mList.add(SearchData("Công Viên Chí Linh", R.drawable.park5))
    }

    private fun addDataArt() {
//        mList.add(SearchData("Bảo Tàng Mĩ Thuật", R.drawable.art1))
//        mList.add(SearchData("D&C Art Gallery", R.drawable.art2))
//        mList.add(SearchData("Bảo Tàng Phụ Nữ Việt Nam", R.drawable.art3))
//        mList.add(SearchData("Nguyen Art Gallery", R.drawable.art4))
//        mList.add(SearchData("Phòng Tranh 3D", R.drawable.art5))
    }

    private fun addDataArtifact() {
//        mList.add(SearchData("Bia Văn Miếu Quốc Tử Giám", R.drawable.artifact1))
//        mList.add(SearchData("Cầu Thê Húc", R.drawable.artifact2))
//        mList.add(SearchData("Tháp Rùa", R.drawable.artifact3))
//        mList.add(SearchData("Con Dấu Triều Nguyễn", R.drawable.artifact4))
//        mList.add(SearchData("Tượng Nghê Đồng (Thế kỉ XVI)", R.drawable.artifact5))
    }

    private fun addDataLiterature() {
//        mList.add(SearchData("Bảo Tàng Văn Học Việt Nam", R.drawable.literature1))
    }

    private fun addDataHistory() {
//        mList.add(SearchData("Văn Miếu Quốc Tử Giám", R.drawable.place2))
//        mList.add(SearchData("Hoàng Thành Thăng Long", R.drawable.place3))
//        mList.add(SearchData("Lăng Chủ Tịch Hồ Chí Minh", R.drawable.place4))
//        mList.add(SearchData("Nhà Tù Hoả Lò", R.drawable.place5))
//        mList.add(SearchData("Văn Miếu Quốc Tử Giám", R.drawable.place1))
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
    private fun addDataLocation() {
//        mList.add(SearchData("Văn Miếu Quốc Tử Giám", R.drawable.place2))
//        mList.add(SearchData("Hoàng Thành Thăng Long", R.drawable.place3))
//        mList.add(SearchData("Lăng Chủ Tịch Hồ Chí Minh", R.drawable.place4))
//        mList.add(SearchData("Nhà Tù Hoả Lò", R.drawable.place5))
//        mList.add(SearchData("Văn Miếu Quốc Tử Giám", R.drawable.place1))
//        mList.add(SearchData("Cổ vật 1", R.drawable.art5))

    }
}