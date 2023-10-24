package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigatorView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Huyen
//        val myIntent = Intent(this, DashboardActivity::class.java)
//        startActivity(myIntent)

        setContentView(R.layout.bottom_navigator)

        bottomNavigatorView = findViewById(R.id.bottom_navigator)
        bottomNavigatorView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.bottom_home -> {
                    replaceFragment(DashboardFragment())
                    true
                }
                R.id.bottom_location -> {
                    replaceFragment(LocationFragment())
                    true
                }
                R.id.bottom_search -> {
                    replaceFragment(SearchFragment())
                    true
                }
                R.id.bottom_archive -> {
                    replaceFragment(ArchiveFragment())
                    true
                }
                R.id.bottom_more -> {
                    replaceFragment(MoreFragment())
                    true
                }
//                R.id.bottom_add -> {
//                    Toast.makeText(this,"Upload sth ..."s, Toast.LENGTH_SHORT).show()
//                    true
//                }
                else -> false
            }
        }
        replaceFragment(DashboardFragment())
    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }

}