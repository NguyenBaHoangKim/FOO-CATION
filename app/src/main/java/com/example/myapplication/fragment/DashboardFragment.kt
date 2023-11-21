package com.example.myapplication.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.model.EventResp
import com.example.common.apiUser.UsersDataManager
import com.example.common.http.apiEven.EventsManager
import com.example.common.utils.Extensions.Companion.toBitMap
import com.example.model.Event
import com.example.model.User
import com.example.myapplication.R
import com.example.myapplication.adapter.EvenAdapter
import com.example.myapplication.adapter.ImageAdapter
import kotlin.math.abs

class DashboardFragment : Fragment() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList: ArrayList<Int>
    private lateinit var adapter: ImageAdapter
    private lateinit var textView4: TextView
    private var usersDataManager = UsersDataManager()

    private lateinit var recyclerView: RecyclerView
    private var eventsManager = EventsManager()
    private var mList = ArrayList<Event>()
    private lateinit var even_adapter:EvenAdapter

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dashboard, container, false)
        val btnSearch:Button = view.findViewById(R.id.searchbtn)
//        val recyclerView:RecyclerView = view.findViewById(R.id.even)
        textView4 = view.findViewById(R.id.textView4)

        recyclerView = view.findViewById(R.id.even)
        recyclerView.setHasFixedSize(true)
        recyclerView = view.findViewById(R.id.even)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

//        even_adapter = EvenAdapter(mList = mList)
//        recyclerView.adapter = even_adapter

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

        btnSearch.setOnClickListener {
            val intent = Intent("com.iphonik.chameleon.SearchActivity")
            startActivity(intent)
        }

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
        usersDataManager.getUsers({ data: User ->
            textView4.text = data.username
            println(data.username)
        }, { error ->
            println(error)
        })

        eventsManager.getEvents({ data: List<EventResp> ->
            for (even in data) {
                mList.add(Event(even.eventName,even.time,even.address,even.image.data.toBitMap()))
                println(even.address)
            }
            even_adapter = EvenAdapter(mList = mList)
            recyclerView.adapter = even_adapter
        }, {error ->
            println(error)
        })
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
    }
}