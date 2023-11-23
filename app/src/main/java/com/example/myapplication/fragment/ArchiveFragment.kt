package com.example.myapplication.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.common.apiUser.UsersDataManager
import com.example.common.http.apiLocationResp.LocationRespManager
import com.example.common.utils.Extensions.Companion.toBitMap
import com.example.model.ArchiveData
import com.example.model.LocationResp
import com.example.model.User
import com.example.myapplication.R
import com.example.myapplication.adapter.ArchiveAdapter
import com.example.popup.InstructionPopup
import com.example.popup.QuizPopup

/**
 * A simple [Fragment] subclass.
 * Use the [ArchiveFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
open class ArchiveFragment : Fragment() {
    private lateinit var recyclerView : RecyclerView
    private var mList = ArrayList<ArchiveData>()
    private  lateinit var adapter: ArchiveAdapter

    private var usersDataManager = UsersDataManager()
    private var locationResp = LocationRespManager()

    private lateinit var userName: TextView

    //new

//    @SuppressLint("MissingInflatedId")
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
        userName = view.findViewById(R.id.user_name)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(activity)

        addDataToList()
        fetchData()
        adapter = ArchiveAdapter(mList)
        recyclerView.adapter = adapter
        adapter.setOnClickListener { position: Int, model: ArchiveData ->
//            val showPopup = QuizPopup()
            val showPopup = InstructionPopup()
            showPopup.show((activity as AppCompatActivity).supportFragmentManager, "")
            showPopup.setId(model.id)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun fetchData() {
        usersDataManager.getUsers({ data: User ->
            userName.text = data.username
            println(data.username)
        }, { error ->
            println(error)
        })
        locationResp.getLocationList({data: List<LocationResp> ->
            for (location in data) {
                mList.add(ArchiveData(location.id, location.name, location.image.data.toBitMap()))
                println(mList.size)
            }
            adapter = ArchiveAdapter(mList)
            recyclerView.adapter = adapter
            println("goi dc archive r cu co location nao thi se co quiz")
        }, { error ->
            println(error)
        })
    }
    private fun addDataToList() {
//        mList.add(ArchiveData("1","Bảo Tàng Mĩ Thuật", R.drawable.art1))
//        mList.add(ArchiveData("2","D&C Art Gallery", R.drawable.art2))
//        mList.add(ArchiveData("3","Bảo Tàng Phụ Nữ Việt Nam", R.drawable.art3))
//        mList.add(ArchiveData("4","Nguyen Art Gallery", R.drawable.art4))
//        mList.add(ArchiveData("5","Phòng Tranh 3D", R.drawable.art5))
//        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.image);
//        mList.add(ArchiveData("1","Bảo Tàng Mĩ Thuật", BitmapFactory.decodeResource(resources, com.example.myapplication.R.drawable.art1)))
//        mList.add(ArchiveData("2","D&C Art Gallery", BitmapFactory.decodeResource(resources, com.example.myapplication.R.drawable.art2)))
//        mList.add(ArchiveData("3","Bảo Tàng Phụ Nữ Việt Nam", BitmapFactory.decodeResource(resources, com.example.myapplication.R.drawable.art3)))
//        mList.add(ArchiveData("4","Nguyen Art Gallery", BitmapFactory.decodeResource(resources, com.example.myapplication.R.drawable.art4)))
//        mList.add(ArchiveData("5","Phòng Tranh 3D", R.drawable.art5))
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