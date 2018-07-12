package com.sharvari.animations;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by sharvari on 12-Jul-18.
 */

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private int LOCATION_CODE = 0;
    private GoogleMap map;
    private SupportMapFragment mapFragment;
    private Location location;
    private LatLng latLng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        permission();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        latLng = new LatLng(19.075984, 72.877656);
        map.addMarker(new MarkerOptions().position(latLng).title("Mumbai"));
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));
    }

    private boolean permission(){

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED  && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, LOCATION_CODE);
            return false;
        }
        return true;
    }
}
