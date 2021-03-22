package com.example.servicesaroundme.CoreCapabilities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.servicesaroundme.MyAccount.loginRegisterationActivity;
import com.example.servicesaroundme.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class homeActivity extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener obj_AuthStateListener;
    //FirebaseAuth obj_FirebaseAuth;
    Button obj_btnLogout;
    DrawerLayout obj_DrawerLayout;
    NavigationView obj_NavigationView;
    Toolbar obj_Toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        obj_btnLogout = findViewById(R.id.btnLogout);
        obj_DrawerLayout = findViewById(R.id.drawer_layout);
        obj_NavigationView = findViewById(R.id.nav_view);
        obj_Toolbar = findViewById(R.id.myToolbar);

        setSupportActionBar(obj_Toolbar);


        obj_btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(homeActivity.this, loginRegisterationActivity.class));
            }
        });

    }
}