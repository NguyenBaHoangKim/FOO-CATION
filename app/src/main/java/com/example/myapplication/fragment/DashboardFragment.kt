package com.example.myapplication.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.common.api.UserDataManager
import com.example.model.LoginRequest
import com.example.model.LoginResp
import com.example.myapplication.ImageAdapter
import com.example.myapplication.R
import kotlin.math.abs

class DashboardFragment : Fragment() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList: ArrayList<Int>
    private lateinit var adapter: ImageAdapter
    private lateinit var textView4: TextView
    private var userDataManager = UserDataManager()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.dashboard, container, false)
        init(view)
        fetchData()
        setUpTransformer()

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 2000)

            }
        })
        return view
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

    private fun fetchData() {
        //::onSuccess
        val loginRequest = LoginRequest("john@example.com", "1")
        userDataManager.login(loginRequest, { data: LoginResp ->
            textView4.text = data.user.username
        }, { error ->
            println(error)
        })
    }

//
//    fun onSuccess(data: List<TestUser>) {
//        for (user in data) {
//            textView4.text = user.name
//            println(user.name)
//        }
//    }

    private fun setUpTransformer(){
        var transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer {page, position ->
            var r = 1 - abs(position)
            page.scaleY = 0.85f + r + 0.14f
        }
        viewPager2.setPageTransformer(transformer)
    }

    private fun init(view: View?){
        viewPager2 = view?.findViewById(R.id.viewPager2) as ViewPager2
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

        textView4 = view.findViewById(R.id.textView4)
    }

}