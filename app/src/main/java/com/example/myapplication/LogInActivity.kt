package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.example.common.apiUser.UserDataManager
import com.example.common.utils.Extensions.Companion.toBitMap
import com.example.common.utils.MyApp
import com.example.common.utils.UserSessionManager
import com.example.model.LoginRequest
import com.example.model.LoginResp
import com.example.model.User
import com.example.myapplication.search.SearchActivity

class LogInActivity : AppCompatActivity() {
    private var userApi = UserDataManager()
    private lateinit var loginRequest: LoginRequest
    private var keyAcess = UserSessionManager(MyApp.context!!)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in)

    }
    fun onMatch(view: View) {
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        loginRequest = LoginRequest(email.text.toString(),password.text.toString())
        login(loginRequest)
        val btn:Button = view.findViewById(R.id.button)

    }
    private fun login(loginRequest: LoginRequest) {
        userApi.login(loginRequest ,{ data: LoginResp ->
            keyAcess.setInfo("accessToken",data.accessKey)
            val i = Intent(this@LogInActivity, MainActivity::class.java)
            startActivity(i)
        }, { error ->
            println(error)

        })
    }
}