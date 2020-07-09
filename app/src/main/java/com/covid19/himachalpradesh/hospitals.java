package com.covid19.himachalpradesh;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class hospitals extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng latLng;
    private FusedLocationProviderClient fusedLocationClient;
    LocationRequest mLocationRequest;
    Location mLastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(180000);
        mLocationRequest.setFastestInterval(90000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
        mMap.setMyLocationEnabled(true);

        // Test Center 1
        final LatLng center1 = new LatLng(31.263632, 77.245731);
        mMap.addMarker(new MarkerOptions().position(center1).title("Dr Y S Parmar Medical College Nahan District Sirmaur, Nahan, Himachal Pradesh").snippet("Phone Number: 0170222209"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center1));

        //Test Center 2
        final LatLng center2 = new LatLng(31.372007, 76.938696);
        mMap.addMarker(new MarkerOptions().position(center2).title("Central Research Institute, Kasauli, Main Campus, Kasauli, Himachal Pradesh").snippet("Phone Number: 01792 272 059"));

        //Test Center 3
        final LatLng center3 = new LatLng(31.578234, 77.173487);
        mMap.addMarker(new MarkerOptions().position(center3).title("Indira Gandhi Medical College & Hospital, Shimla, Himachal Pradesh").snippet("Phone Number: 0177 265 4713"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center3));

        //Test Center 4
        final LatLng center4 = new LatLng(31.938364, 76.257621);
        mMap.addMarker(new MarkerOptions().position(center4).title("Regional Hospital, Una, Himachal Pradesh"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center4));

        //Test Center 5
        final LatLng center5 = new LatLng(32.037297, 76.565272);
        mMap.addMarker(new MarkerOptions().position(center5).title("Dr Radhakrishnan Govt Medical College, Hamirpur, Himachal Pradesh").snippet("Phone Number: 01972 222 999"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center5));

        //Test Center 6
        final LatLng center6 = new LatLng(32.036416, 76.894845);
        mMap.addMarker(new MarkerOptions().position(center6).title("Shri Lal Bahadur Shastri Government Medical College and Hospital, Ner Chowk, Himachal Pradesh").snippet("Phone Number: 01905 243 950"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center6));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(6));

        //Test Center 7
        final LatLng center7 = new LatLng(32.139835, 76.960777);
        mMap.addMarker(new MarkerOptions().position(center7).title("Netaji Subhash Chandra Bose Zonal Hospital, Mandi, Himachal Pradesh"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center7));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if(marker.getPosition().equals(center1)) {
                    Uri uriUrl = Uri.parse("http://www.yspgmc.org/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center2)) {
                    Uri uriUrl = Uri.parse("https://crikasauli.nic.in/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }

                else if(marker.getPosition().equals(center3)) {
                    Uri uriUrl = Uri.parse("http://www.igmcshimla.edu.in/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }

                else if(marker.getPosition().equals(center5)) {
                    Uri uriUrl = Uri.parse("http://www.rgmchamirpur.org/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
                else if(marker.getPosition().equals(center6)) {
                    Uri uriUrl = Uri.parse("http://www.slbsgmcm.in/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
            }
        });

    }

    LocationCallback mLocationCallback=new LocationCallback(){
        @Override
        public void onLocationResult(LocationResult locationResult) {
            for(Location location1 : locationResult.getLocations()) {
                if (getApplicationContext() != null) {
                    mLastLocation = location1;
                    latLng = new LatLng(location1.getLatitude(), location1.getLongitude());
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(7));
                }
            }

        }
    };
    public void onBackPressed(){
        Intent intent = new Intent(hospitals.this, home.class);
        startActivity(intent);
        finish();
    };
}
