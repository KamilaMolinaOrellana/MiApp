package com.proyecto.com.myapplication.CapaDeDatos;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.proyecto.com.myapplication.R;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private Marker marcador;
    double lat = 0.0;
    double lng = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(googleMap.MAP_TYPE_NORMAL);
        // Add a marker in Sydney and move the camera
        LatLng cuenca = new LatLng(-2.90241000, -79.000196);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cuenca, 10));
        //MARCADOR EN CUENCA
        //mMap.addMarker(new MarkerOptions().position(cuenca).title("Marker in Cuenca"));
        //MARCADORES
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2.9014242, -79.0045523)).title
                ("Kamila Molina Orellana").icon(BitmapDescriptorFactory.defaultMarker
                (BitmapDescriptorFactory.HUE_YELLOW)).snippet("~Guia Turistica. ~Interprete"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2.8876513, -79.0313053)).title
                ("Juan José Bedoya").icon(BitmapDescriptorFactory.defaultMarker
                (BitmapDescriptorFactory.HUE_GREEN)).snippet("~Transporte"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2.896752, -79.00177091)).title
                ("Maria Jose Altamirano").icon(BitmapDescriptorFactory.defaultMarker
                (BitmapDescriptorFactory.HUE_ORANGE)).snippet("~Interprete"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2.899375, -79.00838999)).title
                ("Mirian Orellana Vimos").icon(BitmapDescriptorFactory.defaultMarker
                (BitmapDescriptorFactory.HUE_VIOLET)).snippet("~Guia Turistica"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2.8928950, -78.9767432)).title
                ("Edgar Molina Alvarado").icon(BitmapDescriptorFactory.defaultMarker
                (BitmapDescriptorFactory.HUE_YELLOW)).snippet("~Guia Turistica. ~Transporte"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2.8897233, -78.9930081)).title
                ("Karla Peralta Ordonez").icon(BitmapDescriptorFactory.defaultMarker
                (BitmapDescriptorFactory.HUE_ORANGE)).snippet("~Interprete"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2.8925093, -79.0112900)).title
                ("Mateo Carpio Espinoza").icon(BitmapDescriptorFactory.defaultMarker
                (BitmapDescriptorFactory.HUE_YELLOW)).snippet("~Guia Turistica. ~Interprete. ~Transporte"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2.9013814, -79.0345931)).title
                ("Sandra Correa Esmeraldas").icon(BitmapDescriptorFactory.defaultMarker
                (BitmapDescriptorFactory.HUE_VIOLET)).snippet("~Guia Turistica"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2.9021314, -79.0005505)).title
                ("Estuardo Zambrano Ortega").icon(BitmapDescriptorFactory.defaultMarker
                (BitmapDescriptorFactory.HUE_GREEN)).snippet("~Transporte"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2.9062728, -79.0036913)).title
                ("Micaela Chalco Perez").icon(BitmapDescriptorFactory.defaultMarker
                (BitmapDescriptorFactory.HUE_GREEN)).snippet("~Transporte"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2.9135108, -79.0298254)).title
                ("Francisco Zeas Moscoso").icon(BitmapDescriptorFactory.defaultMarker
                (BitmapDescriptorFactory.HUE_ORANGE)).snippet("~Interprete"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2.9033530, -78.9878636)).title
                ("Juan Carrasco Vega").icon(BitmapDescriptorFactory.defaultMarker
                (BitmapDescriptorFactory.HUE_GREEN)).snippet("~Transporte"));
        mMap.addMarker(new MarkerOptions().position(new LatLng(-2.8985955, -79.0031468)).title
                ("Pedro Jimenez Coral").icon(BitmapDescriptorFactory.defaultMarker
                (BitmapDescriptorFactory.HUE_VIOLET)).snippet("~Guia Turistica"));

        miUbicacion();
    }

    private void agregarMarcador(double lat, double lng) {
        LatLng coordenadas = new LatLng(lat, lng);
        CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom(coordenadas, 12);
        if (marcador != null) marcador.remove();
        marcador = mMap.addMarker(new MarkerOptions().position(coordenadas).title(
                "Aqui Estoy").icon(BitmapDescriptorFactory.fromResource(R.mipmap.flag)));
        mMap.animateCamera(miUbicacion);
    }

    private void actualizarUbicacion(Location location) {
        if (location != null) {
            lat = location.getLatitude();
            lng = location.getLongitude();
            agregarMarcador(lat, lng);
        }
    }

    LocationListener losListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            actualizarUbicacion(location);
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
        }
        @Override
        public void onProviderEnabled(String provider) {
        }
        @Override
        public void onProviderDisabled(String provider) {
        }
    };

    private void miUbicacion() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        actualizarUbicacion(location);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER , 1500 , 0 , losListener);
    }




}

