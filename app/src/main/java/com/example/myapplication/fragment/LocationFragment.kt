package com.example.myapplication.fragment

//import com.example.myapplication.MapsActivity

import android.annotation.SuppressLint
import android.content.Intent
import android.location.Location
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.common.http.apiLocationResp.LocationRespManager
import com.example.common.utils.Extensions.Companion.toBitMap
import com.example.common.utils.Extensions.Companion.toBitmap
import com.example.myapplication.LocationDetail
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLocationBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class LocationFragment : Fragment() ,
    GoogleMap.OnMyLocationButtonClickListener,
    GoogleMap.OnMyLocationClickListener{

    private lateinit var mMap: GoogleMap
    private lateinit var btn: Button
    private var locationRespManager = LocationRespManager()
    private var mList = ArrayList<com.example.model.Location>()

    private val hanoi = LatLng(21.028511,105.804817)
    private val vanmieu = LatLng(21.027256,105.832703)

    private lateinit var markerHanoi: Marker
    private var markerPerth: Marker? = null
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val view: View = inflater.inflate(R.layout.fragment_location, container, false)
//        showMap = view.findViewById(R.id.showMap)
//        showMap.setOnClickListener(View.OnClickListener {
//            val intent = Intent(activity, MapsActivity::class.java)
//            startActivity(intent)
//        })
//        return view
//    }

    private var _binding: FragmentLocationBinding? = null
    private var mapFragment: SupportMapFragment? = null
    private val binding get() = _binding!!

    private val callback = OnMapReadyCallback { googleMap ->
        mMap = googleMap
        println("Call back")
        println(mList.size)
        for(i in mList) {
            val diadiemx = LatLng(i.latitude,i.longtitude)
            mMap.addMarker(MarkerOptions().position(diadiemx).title(i.nameInMap))
            println("add dc r")
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hanoi,12f))
        mMap.setOnMarkerClickListener { marker ->
            val intent = Intent(activity, LocationDetail::class.java)
            startActivity(intent)
            false
        }
    }
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_maps, container, false)

        fetchData()
        return view
    }
    private fun fetchData() {
        locationRespManager.getLocationResp({ data: List<com.example.model.LocationResp> ->
            println("okee oke oke")
            for (location in data) {
                println(location.image.data)
                mList.add(com.example.model.Location(location.id,location.name,location.nameInMap,location.latitude,location.longtitude,
                    location.image.data.toBitMap()
                ))
                callback
            }

        }, { error ->
            println(error)
        })
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
    override fun onMyLocationClick(location: Location) {
        Toast.makeText(context, "Current location:\n$location", Toast.LENGTH_LONG)
            .show()
    }
    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(context, "MyLocation button clicked", Toast.LENGTH_SHORT)
            .show()
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false
    }
}