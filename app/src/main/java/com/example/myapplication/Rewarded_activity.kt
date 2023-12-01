package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Rewarded_activity : AppCompatActivity() {
    private lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rewarded)

        btn = findViewById(R.id.back)
        btn.setOnClickListener {
            finish()
        }
    }
}