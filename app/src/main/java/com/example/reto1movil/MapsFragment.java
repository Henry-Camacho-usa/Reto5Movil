package com.example.reto1movil;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            LatLng pointA = new LatLng(52.239164, 20.985462);
            googleMap.addMarker(new MarkerOptions().position(pointA).title("Tienda chico"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(pointA));
            pointA = new LatLng(4.694754, -74.085350);
            googleMap.addMarker(new MarkerOptions().position(pointA).title("Tienda titan"));
            pointA = new LatLng(4.592523, -74.123165);
            googleMap.addMarker(new MarkerOptions().position(pointA).title("Tienda centro mayor"));
            pointA = new LatLng(4.732871, -74.067172);
            googleMap.addMarker(new MarkerOptions().position(pointA).title("Tienda colina"));
            googleMap.moveCamera(CameraUpdateFactory.zoomTo(12.0f));
            LatLng point = new LatLng(4.641499, -74.062134);
            googleMap.addMarker(new MarkerOptions().position(point).title("Tienda principal"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(point));

        }
    };

    public static final CameraPosition SYDNEY =
            new CameraPosition.Builder().target(new LatLng(-33.87365, 151.20689))
                    .zoom(15.5f)
                    .bearing(0)
                    .tilt(25)
                    .build();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}