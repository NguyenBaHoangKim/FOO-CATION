package com.example.myapplication

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class DashboardFragment : Fragment() {
    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler
    private lateinit var imageList: ArrayList<Int>
    private lateinit var adapter: ImageAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.dashboard, container, false)
        init(view)
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
