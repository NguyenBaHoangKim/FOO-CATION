package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.common.apiUser.UserDataManager
import com.example.common.utils.MyApp
import com.example.common.utils.UserSessionManager
import com.example.model.LoginRequest
import com.example.model.LoginResp

class LogInActivity : AppCompatActivity() {
    private var userApi = UserDataManager()
    private lateinit var loginRequest: LoginRequest
    private var sessionManager = UserSessionManager(MyApp.context!!)
    private lateinit var dangky: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in)

        dangky = findViewById(R.id.dangnhap)
        dangky.setOnClickListener{
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
    fun onMatch(view: View) {
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.newpassword)
        loginRequest = LoginRequest(email.text.toString(),password.text.toString())
        login(loginRequest)
        val btn:Button = view.findViewById(R.id.button)
    }
    private fun login(loginRequest: LoginRequest) {
        userApi.login(loginRequest ,{ data: LoginResp ->
            sessionManager.setInfo("accessToken",data.accessKey)
            val i = Intent(this@LogInActivity, MainActivity::class.java)
            startActivity(i)
        }, { error ->
            println(error)
        })
    }
}