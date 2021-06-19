package com.example.servicesaroundme.CoreCapabilities;

import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.servicesaroundme.R;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

//public class homeActivity extends baseActivity implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback, LocationListener {
public class homeActivity extends baseActivity implements OnMapReadyCallback, LocationListener {
    // Variables for FirebaseAuth
    private FirebaseAuth.AuthStateListener obj_AuthStateListener;

    //Variables for Drawer/Navigation View
//    DrawerLayout obj_DrawerLayout;
//    NavigationView obj_NavigationView;
//    Toolbar obj_Toolbar;

    // Variables for Map
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    Location obj_LastLocation;
    GoogleApi obj_GoogleApi;
    private FusedLocationProviderClient obj_FusedlocationProvideClient;
    private LocationCallback locationCallback;
    private Boolean requestingLocationUpdates;
    boolean isPermissionGranted;
    SupportMapFragment supportMapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflate your activity layout here!
        View contentView = inflater.inflate(R.layout.activity_home, null, false);
//        drawerLayout.addView(contentView, 0);

        /* ======================= MAPS =================== */
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.myFragMap);
        mapFragment.getMapAsync(this);

        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                    // Update UI with location data
                    // ...
                }
            }
        };

        /* ===================== Drawer/Navigation ==================== */
//        obj_DrawerLayout = findViewById(R.id.drawer_layout);
//        obj_NavigationView = findViewById(R.id.nav_view);
//        obj_Toolbar = findViewById(R.id.myToolbar);
//
//        setSupportActionBar(obj_Toolbar);
        /*------------ Navigation Drawer Menu ----------------*/
        // Hide and Show items example
        //Menu menu = nv.getMenu();
        //menu.findItem(R.id.menu_logout).setVisible(false);

//        obj_NavigationView.bringToFront();
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, obj_DrawerLayout, obj_Toolbar, R.string.openNavigation, R.string.closeNavigation);
//        obj_DrawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//
//        obj_NavigationView.setNavigationItemSelectedListener(this);
//        obj_NavigationView.setCheckedItem(R.id.menu_home);

//        obj_btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FirebaseAuth.getInstance().signOut();
//                startActivity(new Intent(homeActivity.this, loginRegisterationActivity.class));
//            }
//        });
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
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
        mMap.setMyLocationEnabled(true);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    //    Location Listener functions
    @Override
    public void onLocationChanged(Location location) {
        obj_LastLocation = location;
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
}

