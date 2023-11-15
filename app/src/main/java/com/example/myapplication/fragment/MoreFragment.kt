package com.example.myapplication.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.RewardsActivity

/**
 * A simple [Fragment] subclass.
 * Use the [MoreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MoreFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_more, container, false)
        val btnProfile : Button = view.findViewById(R.id.profile)
        val btnSetting : Button = view.findViewById(R.id.setting)
        val btnReward  : Button = view.findViewById(R.id.reward)
        val btnHelp    : Button = view.findViewById(R.id.help)

        btnReward.setOnClickListener {
            val intent = Intent("com.iphonik.chameleon.RewardsActivity")
            startActivity(intent)
        }
        return view
    }
}