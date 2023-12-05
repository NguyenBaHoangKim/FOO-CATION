package com.example.myapplication.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.apiUser.UserDataManager
import com.example.common.http.apiLocationResp.LocationRespManager
import com.example.common.utils.Extensions.Companion.toBitMap
import com.example.model.ArchiveData
import com.example.model.LocationResp
import com.example.model.User
import com.example.myapplication.R
import com.example.myapplication.adapter.ArchiveAdapter
import com.example.popup.QuizPopup

open class ArchiveFragment : Fragment() {
    private lateinit var recyclerView : RecyclerView
    private var mList = ArrayList<ArchiveData>()
    private  lateinit var adapter: ArchiveAdapter

    private var usersDataManager = UserDataManager()
    private var locationResp = LocationRespManager()

    private lateinit var userName: TextView
    private lateinit var point: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_archive, container, false)

        point = view.findViewById(R.id.point)

        recyclerView = view.findViewById(R.id.recyclerView2)
        userName = view.findViewById(R.id.user_name)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        fetchData()
        adapter = ArchiveAdapter(mList)
        recyclerView.adapter = adapter
        adapter.setOnClickListener { position: Int, model: ArchiveData ->
            val showPopup = QuizPopup()
            showPopup.show((activity as AppCompatActivity).supportFragmentManager, "")
            showPopup.setId(model.id)
        }
        return view
    }

    private fun fetchData() {
        locationResp.getLocationList({data: List<LocationResp> ->
            for (location in data) {
                mList.add(ArchiveData(location.id, location.name, location.image.data.toBitMap()))
                println(mList.size)
            }
            adapter = ArchiveAdapter(mList)
            recyclerView.adapter = adapter
            adapter.setOnClickListener { position: Int, model: ArchiveData ->
                val showPopup = QuizPopup()
                showPopup.show((activity as AppCompatActivity).supportFragmentManager, "")
                showPopup.setId(model.id)
            }
            println("goi dc archive r cu co location nao thi se co quiz")
        }, { error ->
            println(error)
        })
        usersDataManager.getUsers({ data: User ->
            userName.text = data.username
            point.text = data.rankingPoint.toString()
        }, { error ->
            println(error)
        })
    }
}