package com.example.myapplication.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.common.apiUser.UserDataManager
import com.example.common.utils.MyApp
import com.example.common.utils.UserSessionManager
import com.example.myapplication.LogInActivity
import com.example.myapplication.R

/**
 * A simple [Fragment] subclass.
 * Use the [MoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoreFragment : Fragment() {
    private var userApi = UserDataManager()
    private var keyAcess = UserSessionManager(MyApp.context!!)
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

        btnReward.setOnClickListener {
            val intent = Intent("com.iphonik.chameleon.RewardsActivity")
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
}