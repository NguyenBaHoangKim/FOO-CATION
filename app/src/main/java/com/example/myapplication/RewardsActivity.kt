package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

@SuppressLint("MissingInflatedId")

class RewardsActivity : AppCompatActivity() {
    private lateinit var reward1: CardView
    private lateinit var rewarded: Button
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reward)
        val btnBack : ImageButton = findViewById(R.id.reward_back_button)
        reward1 = findViewById(R.id.reward1)
        rewarded = findViewById(R.id.rewarded)

        btnBack.setOnClickListener {
            finish()
        }

        rewarded.setOnClickListener{
            val intent = Intent(this,Rewarded_activity::class.java)
            startActivity(intent)
        }
    }

}