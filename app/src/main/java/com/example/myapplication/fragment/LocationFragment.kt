package com.example.myapplication.fragment

//import com.example.myapplication.MapsActivity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.common.http.apiLocationResp.LocationRespManager
import com.example.common.utils.Extensions.Companion.toBitMap
import com.example.myapplication.LocationDetail
import com.example.myapplication.databinding.FragmentLocationBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class LocationFragment : Fragment(),
    GoogleMap.OnMyLocationButtonClickListener,
    GoogleMap.OnMyLocationClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var btn: Button
    private var locationRespManager = LocationRespManager()
    private var mList = ArrayList<com.example.model.Location>()

    private val hanoi = LatLng(21.028511, 105.804817)
    private val vanmieu = LatLng(21.027256, 105.832703)

    private lateinit var markerHanoi: Marker
    private var _binding: FragmentLocationBinding? = null
    private var mapFragment: SupportMapFragment? = null

    private lateinit var myLocation: Location
    private val binding get() = _binding!!

    @SuppressLint("MissingPermission")
    private val callback = OnMapReadyCallback { googleMap ->

        mMap = googleMap
        for (location in mList) {
            val diadiemx = LatLng(location.latitude, location.longtitude)
            mMap.addMarker(MarkerOptions().position(diadiemx).title(location.name))
        }
        mMap.addMarker(MarkerOptions().position(hanoi).title("Ha noi neeeee"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(myLocation.latitude,myLocation.longitude),13f))
        println(mMap)
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            //request permission.
            //However check if we need to show an explanatory UI first
            if (shouldShowRequestPermissionRationale(
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            ) {
                println("not permitttt")
            } else {
                requestPermissions(
                    arrayOf<String>(
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_NETWORK_STATE
                    ), 2
                )
            }
        } else {
            //we already have the permission. Do any location wizardry now
            mMap.isMyLocationEnabled = true
            mMap.setOnMyLocationChangeListener { arg0 ->
                val height = 120
                val width = 120
                val bitmapdraw = resources.getDrawable(com.example.myapplication.R.drawable.mylocation) as BitmapDrawable
                val b = bitmapdraw.bitmap
                val smallMarker = Bitmap.createScaledBitmap(b, width, height, false)
                myLocation = arg0
                println("vi tri cua toi ra duoc roi")
                mMap.addMarker(
                    MarkerOptions().position(
                        LatLng(
                            arg0.latitude,
                            arg0.longitude
                        )
                    ).title("It's Me!").icon(BitmapDescriptorFactory.fromBitmap(smallMarker))
                )
                println(arg0.latitude.toString() + " " + arg0.longitude.toString())
//                mMap.moveCamera(
//                    CameraUpdateFactory.newLatLngZoom(
//                        LatLng(
//                            arg0.latitude,
//                            arg0.longitude
//                        ), 13f
//                    )
//                )
                for (location in mList) {
                    if (location.latitude == myLocation.latitude && location.longtitude == myLocation.longitude) {
                        val intent = Intent(activity, LocationDetail::class.java)
                        intent.putExtra("locationId", location.id)
                        startActivity(intent)
                    }
                }
            }
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(21.0292381,105.8248274),13f))
        mMap.setOnMarkerClickListener { marker ->
            for (location in mList) {
                if (location.latitude == marker.position.latitude && location.longtitude == marker.position.longitude) {
                    val intent = Intent(activity, LocationDetail::class.java)
                    intent.putExtra("locationId", location.id)
                    startActivity(intent)
                }
            }
            false
        }
    }


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(com.example.myapplication.R.layout.fragment_maps, container, false)
        fetchData()
        return view
    }

    private fun fetchData() {
        locationRespManager.getLocationList({ data: List<com.example.model.LocationResp> ->
            mList.clear()
            println("okee data map location")
            for (location in data) {
                mList.add(
                    com.example.model.Location(
                        location.id,
                        location.name,
                        location.nameInMap,
                        location.latitude,
                        location.longitude,
                        location.image.data.toBitMap(),
                        location.fact
                    )
                )
            }
            mapFragment?.getMapAsync(callback)
        }, { error ->
            println(error)
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapFragment = childFragmentManager.findFragmentById(com.example.myapplication.R.id.map) as SupportMapFragment?
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