package com.example.myapplication

import android.content.AsyncQueryHandler
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import kotlin.math.abs

class DashboardActivity : AppCompatActivity() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList: ArrayList<Int>
    private lateinit var adapter: ImageAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)
        init()
        setUpTransformer()
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)

            }
        })
    }
    override fun onPause(){
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 2000)
    }
    private var runnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }
    private fun setUpTransformer(){
        var transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer {page, position ->
            var r = 1 - abs(position)
            page.scaleY = 0.85f + r + 0.14f
        }
        viewPager2.setPageTransformer(transformer)
    }
    private fun init(){
        viewPager2 = findViewById(R.id.viewPager2)
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()
        imageList.add(R.drawable.place1)
        imageList.add(R.drawable.place2)
        imageList.add(R.drawable.place3)
        imageList.add(R.drawable.place4)
        imageList.add(R.drawable.place5)

        adapter = ImageAdapter(imageList, viewPager2)
        viewPager2.adapter = adapter
        viewPager2.offscreenPageLimit = 3
        viewPager2.clipToPadding = false
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

    }
}