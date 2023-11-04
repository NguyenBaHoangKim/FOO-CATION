package com.example.myapplication

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
import com.example.common.api.LocationData
import com.example.myapplication.adapter.LocationAdapter
import java.util.Locale


class SearchActivity : AppCompatActivity() {
    private lateinit var recyclerView : RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<LocationData>()
    private  lateinit var adapter: LocationAdapter
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

        addDataToList()
        adapter = LocationAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : OnQueryTextListener {
            /**
             * Called when the user submits the query. This could be due to a key press on the
             * keyboard or due to pressing a submit button.
             * The listener can override the standard behavior by returning true
             * to indicate that it has handled the submit request. Otherwise return false to
             * let the SearchView handle the submission by launching any associated intent.
             *
             * @param query the query text that is to be submitted
             *
             * @return true if the query has been handled by the listener, false to let the
             * SearchView perform the default action.
             */
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            /**
             * Called when the query text is changed by the user.
             *
             * @param newText the new content of the query text field.
             *
             * @return false if the SearchView should perform the default action of showing any
             * suggestions if available, true if the action was handled by the listener.
             */
            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }
        })
    }

    private fun  filterList(query: String?){
        if(query != null) {
            val filteredList = ArrayList<LocationData>()
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
    private fun addDataToList() {
        mList.add(LocationData("Văn Miếu Quốc Tử Giám", R.drawable.place2))
        mList.add(LocationData("Hoàng Thành Thăng Long", R.drawable.place3))
        mList.add(LocationData("Lăng Chủ Tịch Hồ Chí Minh", R.drawable.place4))
        mList.add(LocationData("Nhà Tù Hoả Lò", R.drawable.place5))
        mList.add(LocationData("Văn Miếu Quốc Tử Giám", R.drawable.place1))
    }
}