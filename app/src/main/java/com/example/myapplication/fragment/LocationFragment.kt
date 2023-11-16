package com.example.myapplication.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
//import com.example.myapplication.MapsActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMapsBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import com.example.myapplication.databinding.FragmentLocationBinding
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class LocationFragment : Fragment() ,
    GoogleMap.OnMyLocationButtonClickListener,
    GoogleMap.OnMyLocationClickListener{

    private lateinit var mMap: GoogleMap
    private lateinit var btn: Button

    private val hanoi = LatLng(21.028511,105.804817)
    private val vanmieu = LatLng(21.027256,105.832703)

    private lateinit var markerHanoi: Marker
    private var markerPerth: Marker? = null
    private lateinit var showMap: Button
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

//     This property is only valid between onCreateView and
//     onDestroyView.
    private val binding get() = _binding!!

    private val callback = OnMapReadyCallback { googleMap ->
        mMap = googleMap
        mMap.addMarker(MarkerOptions().position(hanoi).title("Hà nội nèee"))
        mMap.addMarker(MarkerOptions().position(vanmieu).title("Văn Miếu Quốc Tử Giám hihii"))
        //        markerPerth = mMap.addMarker(MarkerOptions()
        //            .position(hanoi)
        //            .title("Hà nội nèee")
        //        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hanoi,12f))
        //        mMap.setMinZoomPreference(13.0f)
        //        mMap.setOnMarkerClickListener(this)
    }
//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//        val vanmieu = LatLng(21.027256,105.832703)
//        val hanoi = LatLng(21.028511,105.804817)
//        mMap.addMarker(MarkerOptions().position(hanoi).title("Hà nội nèee"))
//        mMap.addMarker(MarkerOptions().position(vanmieu).title("Văn Miếu Quốc Tử Giám hihii"))
//    //        markerPerth = mMap.addMarker(MarkerOptions()
//    //            .position(hanoi)
//    //            .title("Hà nội nèee")
//    //        )
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hanoi,12f))
//    //        mMap.setMinZoomPreference(13.0f)
//    //        mMap.setOnMarkerClickListener(this)
//    }
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_maps, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
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