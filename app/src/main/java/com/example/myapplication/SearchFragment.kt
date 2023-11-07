package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.myapplication.R.id
import com.example.myapplication.search.LocationCategory

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
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    @SuppressLint("MissingInflatedId")
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

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SearchFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}