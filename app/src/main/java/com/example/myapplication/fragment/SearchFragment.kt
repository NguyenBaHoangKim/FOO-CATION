package com.example.myapplication.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myapplication.MainActivity
import com.example.myapplication.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
    var mainActivity: MainActivity? = null
    fun SearchFragment() {}
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view:View = inflater.inflate(R.layout.fragment_search, container, false)

        val btn:Button = view.findViewById(R.id.button4)

        val btnLocationCategory:Button = view.findViewById(R.id.location)
        val btnHistoryCategory : Button = view.findViewById(R.id.history)
        val btnLiteratureCategory : Button = view.findViewById(R.id.literature)
        val btnArtifactCategory : Button = view.findViewById(R.id.artifact)
        val btnArtCategory : Button = view.findViewById(R.id.art)
        val btnParkCategory : Button = view.findViewById(R.id.park)

        btn.setOnClickListener {
            val intent = Intent("com.iphonik.chameleon.SearchActivity")
            startActivity(intent)
        }

        btnLocationCategory.setOnClickListener {
            val intent = Intent("com.iphonik.chameleon.LocationCategory")
            startActivity(intent)
        }

        btnHistoryCategory.setOnClickListener {
            val intent = Intent("com.iphonik.chameleon.HistoryCategory")
            startActivity(intent)
        }

        btnLiteratureCategory.setOnClickListener {
            val intent = Intent("com.iphonik.chameleon.LiteratureCategory")
            startActivity(intent)
        }

        btnArtifactCategory.setOnClickListener{
            val intent = Intent("com.iphonik.chameleon.ArtifactCategory")
            startActivity(intent)
        }

        btnArtCategory.setOnClickListener{
            val intent = Intent("com.iphonik.chameleon.ArtCategory")
            startActivity(intent)
        }
        btnParkCategory.setOnClickListener {
            val intent = Intent("com.iphonik.chameleon.ParkCategory")
            startActivity(intent)
        }
        return view
    }



}