package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RepasswordActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var btnback: Button
    private lateinit var pass: EditText
    private lateinit var newpass: EditText
    private lateinit var newrepass: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repassword)

        btnback = findViewById(R.id.back)
        btnback.setOnClickListener {
            finish()
        }

        btn = findViewById(R.id.btndoi)

    }
}