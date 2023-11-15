package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
@SuppressLint("MissingInflatedId")

class RewardsActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reward)
        val btnBack : ImageButton = findViewById(R.id.reward_back_button)
        btnBack.setOnClickListener {
            finish()
        }
    }

}