package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.common.apiUser.UserDataManager
import com.example.model.Repassword
import com.example.model.User

class RepasswordActivity : AppCompatActivity() {
    private val usersDataManager = UserDataManager()
    private lateinit var repassword: Repassword

    private lateinit var btn: Button
    private lateinit var btnback: Button
    private lateinit var pass: EditText
    private lateinit var newpass: EditText
    private lateinit var newrepass: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repassword)

        pass = findViewById(R.id.password)
        newpass = findViewById(R.id.newpassword)
        newrepass = findViewById(R.id.newrepassword)
        repassword = Repassword(pass.text.toString(),newpass.text.toString(),newrepass.text.toString())

        btnback = findViewById(R.id.back)
        btnback.setOnClickListener {
            finish()
        }

        btn = findViewById(R.id.change)
        btn.setOnClickListener {
            onMatch()
        }

    }

    fun onMatch(){
        repassword = Repassword(pass.text.toString(),newpass.text.toString(),newrepass.text.toString())
        println("user : " + repassword)
        changePassword(repassword)
    }

    fun changePassword(repassword : Repassword){
        usersDataManager.changePassword(repassword,{ data: User ->
            println("gui di:  " + repassword)
            Toast.makeText(this, "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show()
        }, { error ->
            println(error)
        })
    }
}