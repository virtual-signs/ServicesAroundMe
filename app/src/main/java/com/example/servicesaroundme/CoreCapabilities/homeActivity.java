package com.example.servicesaroundme.CoreCapabilities;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.servicesaroundme.R;
import com.google.android.material.internal.NavigationMenu;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

//public class homeActivity extends baseActivity implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback, LocationListener {
public class homeActivity extends baseActivity {
    TextView tvTest;
    Button btnLogout;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvTest = findViewById(R.id.test);
        btnLogout = findViewById(R.id.btn_Logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(homeActivity.this, baseActivity.class));
            }
        });
    }
}

