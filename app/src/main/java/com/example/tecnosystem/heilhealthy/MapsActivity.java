package com.example.tecnosystem.heilhealthy;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import HttpConecction.HttpConecction;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MapView mvMapa;

    LatLng miPosicion;
    private Marker markerDocente;
    private Marker markerPosicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mvMapa = (MapView) findViewById(R.id.map);
        mvMapa.onCreate(savedInstanceState);

        mvMapa.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Location location = obtenerLocation();

        double latitud = location.getLatitude();
        double longitud = location.getLongitude();

        // Add a marker in Sydney and move the camera
        //LatLng miPosicion = new LatLng(4.540878,-75.6673385);
        miPosicion = new LatLng(latitud, longitud);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        //El metodo .icon() nos sirve para colocar el icono qe deseemos
        markerPosicion = mMap.addMarker(new MarkerOptions().position(miPosicion).title("Mi ubicacion"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(miPosicion, 15));
    }

    public Location obtenerLocation() {
        //Objeto que utilizamos para trabajar en el servicio d ela ubicacion
        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //la ubicacion que obtenermo es por medio de la red de internet
        Location myLocation = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if (myLocation == null) {
            //permite crear los criterios para traajar con el proveedor de localizacion
            Criteria criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_FINE);
            //le mandamos al objeto manager el provedor que vamos atrabajar deacuerdo al criterio que definimos
            String provider = lm.getBestProvider(criteria, true);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {

                return myLocation;

            }
            myLocation = lm.getLastKnownLocation(provider);
        }
        return myLocation;
    }







    protected void onDestroy() {
        super.onDestroy();
        mvMapa.onDestroy();
    }

    protected void onPause() {
        super.onPause();
        mvMapa.onPause();
    }

    protected void onResume() {
        super.onResume();
        mvMapa.onResume();
    }


}
