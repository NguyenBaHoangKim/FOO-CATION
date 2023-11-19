package com.example.myapplication.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.model.ArchiveData
import com.example.myapplication.LocationDetail
import com.example.myapplication.R
import com.example.myapplication.adapter.ArchiveAdapter
import com.example.myapplication.adapter.ArchiveAdapter.OnClickListener
import com.example.popup.DailogPopup
import com.example.popup.QuizzPopup

/**
 * A simple [Fragment] subclass.
 * Use the [ArchiveFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
open class ArchiveFragment : Fragment() {
    private lateinit var recyclerView : RecyclerView
    private var mList = ArrayList<ArchiveData>()
    private  lateinit var adapter: ArchiveAdapter

    //new

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_archive, container, false)
//        val quiz = QuizFragment()
//        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
//        transaction.replace(QuizFragment())

        recyclerView = view.findViewById(R.id.recyclerView2)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        addDataToList()
        adapter = ArchiveAdapter(mList)
        adapter.setOnClickListener { position: Int, model: ArchiveData ->
            val showPopup = QuizzPopup()
            showPopup.show((activity as AppCompatActivity).supportFragmentManager, "")

//            val intent = Intent("com.iphonik.chameleon.SearchActivity" )
//            // Passing the data to the
//            // EmployeeDetails Activity
//            intent.putExtra("locationId", model.id)
//            startActivity(intent)
        }
        recyclerView.adapter = adapter

        return view
    }
    private fun addDataToList() {
        mList.add(ArchiveData("1","Bảo Tàng Mĩ Thuật", R.drawable.art1))
        mList.add(ArchiveData("2","D&C Art Gallery", R.drawable.art2))
        mList.add(ArchiveData("3","Bảo Tàng Phụ Nữ Việt Nam", R.drawable.art3))
        mList.add(ArchiveData("4","Nguyen Art Gallery", R.drawable.art4))
        mList.add(ArchiveData("5","Phòng Tranh 3D", R.drawable.art5))
    }


//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val btn_quiz : Button = view.findViewById(R.id.button2)
//        btn_quiz.setOnClickListener { view ->
//
//        }
//    }


}