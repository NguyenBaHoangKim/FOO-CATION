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
import com.example.model.Event
import com.example.common.apiUser.UsersDataManager
import com.example.common.http.apiEven.EventsManager
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

    private lateinit var evenName: TextView

//    private lateinit var recyclerView:RecyclerView
    private var eventsManager = EventsManager()
    private var mList = ArrayList<Event>()
    private lateinit var even_adapter:EvenAdapter
    private var usersDataManager = UsersDataManager()

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.dashboard, container, false)
        val btnSearch:Button = view.findViewById(R.id.searchbtn)
        val recyclerView:RecyclerView = view.findViewById(R.id.even)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        addData()
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

    private fun addData() {
        println(R.drawable.even1)
        mList.add(Event(2131165363,"Triển lãm: &quot;Thuỷ triều cảm xúc &quot;","Thời gian: 04/10/2023 - 30/03/2024", "Địa điểm: Trung tâm nghệ thuật Đương đại Vincom (VCCA)" ))
        mList.add(Event(R.drawable.even2,"&quot;Phiêu đậm chất tôi&quot;","Thời gian: 15/11/2023 - 16/11/2023", "Địa điểm: Phố đi bộ hồ Gươm" ))
        mList.add(Event(R.drawable.even3,"Hội chợ: &quot;Xinh fest&quot;","Thời gian: 05/12/2023 - 10/12/2023", "Địa điểm: complex01"))
        mList.add(Event(R.drawable.even4,"Born Pink","Thời gian: 08/10/2023 - 10/10/2023", "Địa điểm: Sân vận dộng Mỹ Đình"))

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
    }

    private fun fetchDataEvent(){
        eventsManager.getEvents({ data: List<Event> ->
            for (even in data) {
                evenName.text = even.eventName
                println(even.address)
            }
            println(data.size)
            even_adapter = EvenAdapter(mList = mList)
//            recyclerView.adapter = even_adapter
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

        textView4 = view.findViewById(R.id.textView4)
    }
}