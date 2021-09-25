package com.example.servicesaroundme.CoreCapabilities;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.servicesaroundme.R;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class baseActivity extends AppCompatActivity {
    public DrawerLayout drawerLayout;
    NavigationView  navigationView;
    Toolbar toolbar;
    AppBarConfiguration appBarConfig;
    ImageView homeImage, userImage, perfImage, helpImage, logInOutImage;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        // Navigation Drawer hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view_top);

        // Toolbar hooks
        toolbar = findViewById(R.id.toolbar);

        // Initialise & setup
        setSupportActionBar(toolbar);
        navigationView.bringToFront();
        navigationView.setItemIconTintList(null);
        navigationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.close();
            }
        });

        // Navigation View setup
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openNavigation, R.string.closeNavigation);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Setup Nav Controller
        NavController navController = Navigation.findNavController(this, R.id.navHostFrag);
        NavigationUI.setupWithNavController(navigationView, navController);
    }
}