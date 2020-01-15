package com.example.app.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.app.CAMERA_TARGET
import com.example.app.MAPKIT_API_KEY
import com.example.app.R
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider
import org.koin.core.KoinComponent

class FeedFragment : Fragment(), KoinComponent {
    private lateinit var mapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        MapKitFactory.setApiKey(MAPKIT_API_KEY)
        MapKitFactory.initialize(context)
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView = view.findViewById(R.id.mainMapView)
        mapView.map.move(CameraPosition(CAMERA_TARGET, 15.0f, 0.0f, 0.0f))
        with(mapView.map) {
            val pic = ImageProvider.fromResource(context, R.drawable.baseline_beenhere_black)
            mapObjects.addPlacemark(
                Point(
                    CAMERA_TARGET.latitude,
                    CAMERA_TARGET.longitude
                ), pic
            )
            mapObjects.addPlacemark(
                CAMERA_TARGET
            )
        }
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        mapView.onStart()
    }

    override fun onStop() {
        mapView.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }
}