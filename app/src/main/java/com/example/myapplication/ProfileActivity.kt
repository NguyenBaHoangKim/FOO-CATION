package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button

import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.common.apiUser.UserDataManager
import com.example.common.utils.Extensions.Companion.toBitMap
import com.example.model.User
import de.hdodenhof.circleimageview.CircleImageView

class ProfileActivity : AppCompatActivity() {
    private lateinit var btn: Button
    private lateinit var save: Button

    private lateinit var displayName: TextView

    private lateinit var name: EditText
    private lateinit var login_name: EditText
    private lateinit var point: TextView
    private lateinit var email: EditText
    private lateinit var repassword: TextView
    private lateinit var avt: CircleImageView

//    private lateinit var password: EditText
    private var usersDataManager = UserDataManager()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)

        displayName = findViewById(R.id.displayName)

        name = findViewById(R.id.name)
        login_name = findViewById(R.id.login_name)
        email = findViewById(R.id.email)
        point = findViewById(R.id.point)
        avt = findViewById(R.id.profile_image)

        repassword = findViewById(R.id.repassword)
        repassword.setOnClickListener{
            val intent = Intent(this,RepasswordActivity::class.java)
            startActivity(intent)
        }

        btn = findViewById(R.id.back)
        btn.setOnClickListener {
            finish()
        }
        getUser()
    }
    private fun getUser() {
        usersDataManager.getUsers({ data: User ->
            avt.setImageBitmap(data.avatar.data.toBitMap())
            displayName.text = data.displayName
            name.hint = data.username
            login_name.hint = data.displayName
            email.hint = data.email
            point.text = data.rankingPoint.toString()
            intent.putExtra("userId", data.id)
            println(data.username)
        }, { error ->
            println(error)
        })
    }

}