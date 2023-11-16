//package com.example.myapplication
//
//import android.content.pm.PackageManager
//import android.location.Location
//import android.os.Bundle
//import android.widget.Button
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.content.ContextCompat
//import com.example.myapplication.databinding.ActivityMapsBinding
//import com.google.android.gms.maps.CameraUpdateFactory
//import com.google.android.gms.maps.GoogleMap
//import com.google.android.gms.maps.OnMapReadyCallback
//import com.google.android.gms.maps.SupportMapFragment
//import com.google.android.gms.maps.model.LatLng
//import com.google.android.gms.maps.model.LatLngBounds
//import com.google.android.gms.maps.model.Marker
//import com.google.android.gms.maps.model.MarkerOptions
//import com.google.android.gms.tasks.OnSuccessListener
//
//
//class MapsActivity : AppCompatActivity(),
//    GoogleMap.OnMyLocationButtonClickListener,
//    GoogleMap.OnMyLocationClickListener,
//    OnMapReadyCallback{
//
//    private lateinit var mMap: GoogleMap
//    private lateinit var binding: ActivityMapsBinding
//    private lateinit var btn: Button
//
//    private val hanoi = LatLng(21.028511,105.804817)
//    private val vanmieu = LatLng(21.027256,105.832703)
//
//    private lateinit var markerHanoi: Marker
//    private var markerPerth: Marker? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityMapsBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        val mapFragment = supportFragmentManager
//            .findFragmentById(R.id.map) as SupportMapFragment
//        mapFragment.getMapAsync(this)
//
//        btn = findViewById(R.id.back_map)
//        btn.setOnClickListener {
//            finish()
//        }
//
//    }
//
//    override fun onMapReady(googleMap: GoogleMap) {
//        mMap = googleMap
//
//        val vanmieu = LatLng(21.027256,105.832703)
//        val hanoi = LatLng(21.028511,105.804817)
////        mMap.addMarker(MarkerOptions().position(hanoi).title("Hà nội nèee"))
//        mMap.addMarker(MarkerOptions().position(vanmieu).title("Văn Miếu Quốc Tử Giám hihii"))
//
//        markerPerth = mMap.addMarker(MarkerOptions()
//            .position(hanoi)
//            .title("Hà nội nèee")
//        )
//
//        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(hanoi,12f))
////        mMap.setMinZoomPreference(13.0f)
////        mMap.setOnMarkerClickListener(this)
//
//    }
//
//    override fun onMyLocationClick(location: Location) {
//        Toast.makeText(this, "Current location:\n$location", Toast.LENGTH_LONG)
//            .show()
//    }
//
//    override fun onMyLocationButtonClick(): Boolean {
//        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT)
//            .show()
//        // Return false so that we don't consume the event and the default behavior still occurs
//        // (the camera animates to the user's current position).
//        return false
//    }
//
//
//
//}