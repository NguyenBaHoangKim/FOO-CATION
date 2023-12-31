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
import com.example.myapplication.search.Category
import com.example.myapplication.search.SearchActivity

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
              val intent = Intent(activity, SearchActivity::class.java)
            startActivity(intent)

        }

        btnLocationCategory.setOnClickListener {
            val id:Int = R.id.location
            val intent = Intent(activity, Category::class.java)
            intent.putExtra("key", id)
            startActivity(intent)
        }

        btnHistoryCategory.setOnClickListener {
            val id:Int = R.id.history
            val intent = Intent(activity, Category::class.java)
            intent.putExtra("key", id)
            startActivity(intent)
        }

        btnLiteratureCategory.setOnClickListener {
            val id:Int = R.id.literature
            val intent = Intent(activity, Category::class.java)
            intent.putExtra("key", id)
            startActivity(intent)
        }

        btnArtifactCategory.setOnClickListener{
            val id:Int = R.id.artifact
            val intent = Intent(activity, Category::class.java)
            intent.putExtra("key", id)
            startActivity(intent)
        }

        btnArtCategory.setOnClickListener{
            val id:Int = R.id.art
            val intent = Intent(activity, Category::class.java)
            intent.putExtra("key", id)
            startActivity(intent)
        }
        btnParkCategory.setOnClickListener {
            val id:Int = R.id.park
            val intent = Intent(activity, Category::class.java)
            intent.putExtra("key", id)
            startActivity(intent)
        }
        return view
    }



}