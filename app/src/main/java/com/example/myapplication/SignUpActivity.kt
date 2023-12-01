package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.common.apiUser.UserDataManager
import com.example.model.Signup
import com.example.model.SignupRequest


class SignUpActivity : AppCompatActivity() {
    private lateinit var signupRequest: SignupRequest
    private var userApi = UserDataManager()

    private lateinit var dangnhap: TextView

    private lateinit var ten: EditText
    private lateinit var hovaten: EditText
    private lateinit var mail: EditText
    private lateinit var pass: EditText
    private lateinit var repass: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)

        ten = findViewById(R.id.ten)

        val btn: Button = findViewById(R.id.button)
        dangnhap = findViewById(R.id.dangnhap)

        ten = findViewById(R.id.ten) as EditText
        hovaten = findViewById(R.id.hovaten)
        mail = findViewById<EditText>(R.id.mail)
        pass = findViewById<EditText>(R.id.pass)
        repass = findViewById<EditText>(R.id.repass)
        signupRequest = SignupRequest(
            ten.text.toString(),
            hovaten.text.toString(),
            mail.text.toString(),
            pass.text.toString(),
            repass.text.toString()
        )

        dangnhap.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

        btn.setOnClickListener {
            onMatchSignUp()
            Toast.makeText(
                this@SignUpActivity,
                "in ra duọc" + ten.text.toString(),
                Toast.LENGTH_SHORT
            ).show()
            println("in duoc")
        }

    }

    fun onMatchSignUp() {
        signupRequest = SignupRequest(
            ten.text.toString(),
            hovaten.text.toString(),
            mail.text.toString(),
            pass.text.toString(),
            repass.text.toString()
        )
        signUp(signupRequest)
//        val btn: Button = view.findViewById(R.id.button)
        println("ten o onMatch:  " + ten)
    }

    fun signUp(signupRequest: SignupRequest) {
        userApi.signUp(signupRequest, { data: Signup ->
            println("email o signUp" + data.email.toString())
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
//            fun Context.toast(message: CharSequence) =
//                Toast.makeText(this, "Đăng kí thành công", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Đăng kí thành công", Toast.LENGTH_SHORT).show()
        }, { error ->
            Toast.makeText(this, "Đăng kí thất bại, vui lòng đăng ký lại", Toast.LENGTH_SHORT)
                .show()
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            println(error)
        })
    }
}
