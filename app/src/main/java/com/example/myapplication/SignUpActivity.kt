package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.common.apiUser.UserDataManager
import com.example.model.Signup
import com.example.model.SignupRequest

class SignUpActivity : AppCompatActivity() {
    private lateinit var signupRequest: SignupRequest
    private var userApi = UserDataManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)
        val btn: Button = findViewById(R.id.button)
        btn.setOnClickListener {
            onMatch()
        }
    }

    fun onMatch() {
        val ten = findViewById<EditText>(R.id.ten)
        val hovaten = findViewById<EditText>(R.id.hovaten)
        val mail = findViewById<EditText>(R.id.mail)
        val pass = findViewById<EditText>(R.id.pass)
        val repass = findViewById<EditText>(R.id.repass)
        signupRequest = SignupRequest(ten.text.toString(),hovaten.text.toString(),mail.text.toString(),pass.text.toString(),repass.text.toString())
        signUp(signupRequest)
//        val btn: Button = view.findViewById(R.id.button)
    }

    fun signUp(signupRequest: SignupRequest) {
        userApi.signUp(signupRequest ,{ data: Signup ->
            val intent = Intent(this,LogInActivity::class.java)
            startActivity(intent)
//            fun Context.toast(message: CharSequence) =
//                Toast.makeText(this, "Đăng kí thành công", Toast.LENGTH_SHORT).show()
          Toast.makeText(this, "Đăng kí thành công", Toast.LENGTH_SHORT).show()
        }, { error ->
            Toast.makeText(this, "Đăng kí thất bại, vui lòng đăng ký lại", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
            println(error)
        })
    }
}
