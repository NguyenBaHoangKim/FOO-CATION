package com.example.myapplication.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.common.apiUser.UsersDataManager
import com.example.common.utils.MyApp
import com.example.common.utils.UserSessionManager
import com.example.model.User
import com.example.myapplication.LogInActivity
import com.example.myapplication.ProfileActivity
import com.example.myapplication.R
import com.example.myapplication.RewardsActivity

class MoreFragment : Fragment() {
    private var usersDataManager = UsersDataManager()
    private var keyAcess = UserSessionManager(MyApp.context!!)
    private lateinit var name: TextView
    private lateinit var point: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_more, container, false)
        val btnProfile : Button = view.findViewById(R.id.profile)
        val btnSetting : Button = view.findViewById(R.id.setting)
        val btnReward  : Button = view.findViewById(R.id.reward)
        val btnLogOut    : Button = view.findViewById(R.id.logOut)
        name = view.findViewById(R.id.name)
        point = view.findViewById(R.id.point)
        fetchData()
        btnReward.setOnClickListener {
            val intent = Intent(activity, RewardsActivity::class.java)
            startActivity(intent)
        }

        btnProfile.setOnClickListener {
            val intent = Intent(activity, ProfileActivity::class.java)
            startActivity(intent)
        }

        btnLogOut.setOnClickListener {
            logOut()
        }

        return view
    }

    private fun logOut() {
        keyAcess.setInfo("accessToken","")
        val intent = Intent(activity, LogInActivity::class.java)
        startActivity(intent)
    }

    private fun fetchData() {
        usersDataManager.getUsers({ data: User ->
            name.text = data.username
            point.text = data.rankingPoint.toString()
        }, { error ->
            println(error)
        })
    }
}