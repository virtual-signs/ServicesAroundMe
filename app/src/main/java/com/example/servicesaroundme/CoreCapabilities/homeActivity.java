package com.example.servicesaroundme.CoreCapabilities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.servicesaroundme.Favourites.favouritesActivity;
import com.example.servicesaroundme.Feedback.feedbackActivity;
import com.example.servicesaroundme.Help.helpActivity;
import com.example.servicesaroundme.Inbox.inboxActivity;
import com.example.servicesaroundme.MyAccount.loginRegisterationActivity;
import com.example.servicesaroundme.MyAccount.userAccountActivity;
import com.example.servicesaroundme.OrderPurchases.ordersActivity;
import com.example.servicesaroundme.PreferencesUserMgmt.preferencesActivity;
import com.example.servicesaroundme.QuotesMgmt.quotesActivity;
import com.example.servicesaroundme.R;
import com.example.servicesaroundme.ServiceCatalogue.serviceCatalogueActivity;
import com.example.servicesaroundme.Testing.testActivity;
import com.example.servicesaroundme.Testing.testMapsActivity;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static com.google.android.gms.location.LocationServices.getFusedLocationProviderClient;

public class homeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback, LocationListener {
    private FirebaseAuth.AuthStateListener obj_AuthStateListener;
    //FirebaseAuth obj_FirebaseAuth;
    DrawerLayout obj_DrawerLayout;
    NavigationView obj_NavigationView;
    Toolbar obj_Toolbar;
    private GoogleMap mMap;
    SupportMapFragment mapFragment;
    Location obj_LastLocation;
    LocationRequest obj_LocationRequest;
    GoogleApi obj_GoogleApi;
    private FusedLocationProviderClient obj_FusedlocationProvideClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        /* ======================= MAPS =================== */
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        setupMapsOnCreate();

        /* ========================================= */


        obj_DrawerLayout = findViewById(R.id.drawer_layout);
        obj_NavigationView = findViewById(R.id.nav_view);
        obj_Toolbar = findViewById(R.id.myToolbar);

        setSupportActionBar(obj_Toolbar);
        /*------------ Navigation Drawer Menu ----------------*/
        // Hide and Show items example
        //Menu menu = nv.getMenu();
        //menu.findItem(R.id.menu_logout).setVisible(false);

        obj_NavigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, obj_DrawerLayout, obj_Toolbar, R.string.openNavigation, R.string.closeNavigation);
        obj_DrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        obj_NavigationView.setNavigationItemSelectedListener(this);
        obj_NavigationView.setCheckedItem(R.id.menu_home);

/*        obj_btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(homeActivity.this, loginRegisterationActivity.class));
            }
        });*/

    }

    private void setupMapsOnCreate() {
        obj_FusedlocationProvideClient = LocationServices.getFusedLocationProviderClient(this);
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
        obj_FusedlocationProvideClient.getLastLocation()
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            // Logic to handle location object
                        }
                    }
                });

        if (ActivityCompat.checkSelfPermission(homeActivity.this, ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            //getCurrentLocation();
        }
        else{
            ActivityCompat.requestPermissions(homeActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
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




    private void getCurrentLocation() {

         if (ActivityCompat.checkSelfPermission(this, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Task<Location> tsk = obj_FusedlocationProvideClient.getLastLocation();
        tsk.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                // on success
                if(location != null){
                    // sync map
                    mapFragment.getMapAsync(new OnMapReadyCallback() {
                        @Override
                        public void onMapReady(GoogleMap googleMap) {
                            //init lat long
                            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                            // marker options
                            MarkerOptions  options = new MarkerOptions().position(latLng).title("HERE I AM");
                            //Zoom
                            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10));
                            googleMap.addMarker(options);
                        }
                    });
                }
            }
        });
    }



    //    Location Listner functions
    @Override
    public void onLocationChanged(Location location) {

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

    protected void createLocationRequest() {
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }


    @Override
    public void onBackPressed() {
        if (obj_DrawerLayout.isDrawerOpen(GravityCompat.START)) {
            obj_DrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.menu_feedback:
                i = new Intent(homeActivity.this, feedbackActivity.class);
                startActivity(i);
                break;
            case R.id.menu_fovourites:
                i = new Intent(homeActivity.this, favouritesActivity.class);
                startActivity(i);
                break;
            case R.id.menu_help:
                i = new Intent(homeActivity.this, helpActivity.class);
                startActivity(i);
                break;
            case R.id.menu_home:
                i = new Intent(homeActivity.this, homeActivity.class);
                startActivity(i);
                break;
            case R.id.menu_inbox:
                i = new Intent(homeActivity.this, inboxActivity.class);
                startActivity(i);
                break;
            case R.id.menu_login:
                i = new Intent(homeActivity.this, loginRegisterationActivity.class);
                startActivity(i);
                Toast.makeText(this, "LOG IN example", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_logout:
                // logout and then move to login window
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(homeActivity.this, loginRegisterationActivity.class));
//                i = new Intent(homeActivity.this, loginRegisterationActivity.class);
//                startActivity(i);
                Toast.makeText(this, "LOG OUT example", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_orders:
                i = new Intent(homeActivity.this, ordersActivity.class);
                startActivity(i);
                break;
            case R.id.menu_preferences:
                i = new Intent(homeActivity.this, preferencesActivity.class);
                startActivity(i);
                break;
            case R.id.menu_quote:
                i = new Intent(homeActivity.this, quotesActivity.class);
                startActivity(i);
                break;
            case R.id.menu_services_catalogue:
                i = new Intent(homeActivity.this, serviceCatalogueActivity.class);
                startActivity(i);
                break;
            case R.id.menu_user_account:
//                i = new Intent(homeActivity.this, userAccountActivity.class);
                i = new Intent(homeActivity.this, testMapsActivity.class);
                startActivity(i);
                break;
            default:

        }
        obj_DrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}