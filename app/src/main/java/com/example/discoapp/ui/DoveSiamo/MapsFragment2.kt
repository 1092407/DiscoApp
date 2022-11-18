package com.example.discoapp.ui.DoveSiamo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.discoapp.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsFragment2 : Fragment() {

    private val callback = OnMapReadyCallback { googleMap ->
        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        /*
        val sydney = LatLng(-34.0, 151.0)
        googleMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
         */
        val donoma = LatLng(43.30596733454052, 13.730025907938705)
        googleMap.addMarker(MarkerOptions().position(donoma).title("Marker in Donoma"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(donoma))

        val brahma = LatLng(43.29531797531458, 13.735240630687098)
        googleMap.addMarker(MarkerOptions().position(brahma).title("Marker in Brahma"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(brahma))

        val la_serra = LatLng(43.29448736298287, 13.733617946030646)
        googleMap.addMarker(MarkerOptions().position(la_serra).title("Marker in La Serra"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(la_serra))

        val le_gall = LatLng(43.19856921167434, 13.791248130687098)
        googleMap.addMarker(MarkerOptions().position(le_gall).title("Marker in Le Gall Discoteca"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(le_gall))

        val luxury = LatLng(43.178816670176694, 13.78422918465645)
        googleMap.addMarker(MarkerOptions().position(luxury).title("Marker in Luxury"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(luxury))

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}