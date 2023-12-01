package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.common.apiUser.UsersDataManager
import com.example.model.User

class ProfileActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var save: Button

    private lateinit var name: EditText
    private lateinit var login_name: EditText
    private lateinit var point: TextView
    private lateinit var email: EditText

//    private lateinit var password: EditText
    private var usersDataManager = UsersDataManager()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        name = findViewById(R.id.name)
        login_name = findViewById(R.id.login_name)
        email = findViewById(R.id.email)
        point = findViewById(R.id.point)

        btn = findViewById(R.id.back)
        btn.setOnClickListener {
            finish()
        }
        getUser()
    }

    private fun getUser() {
        usersDataManager.getUsers({ data: User ->
            name.hint = data.username
            login_name.hint = data.displayName
            email.hint = data.email
            point.text = data.rankingPoint.toString()
            println(data.username)
        }, { error ->
            println(error)
        })
    }

}