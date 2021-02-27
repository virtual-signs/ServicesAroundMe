package com.example.servicesaroundme.MyAccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.servicesaroundme.R;
import com.example.servicesaroundme.Testing.testActivity;
import com.example.servicesaroundme.Testing.testMapsActivity;

public class loginRegisterationActivity extends AppCompatActivity {
    // 1-Define Objects
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_registeration);

        //2-Find object by id
        btnLogin = findViewById(R.id.btnLogin);

        //3-create functions for objects
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(loginRegisterationActivity.this, testMapsActivity.class);
                //Intent homeIntent = new Intent(loginRegisterationActivity.this, testActivity.class);
                // Intent homeIntent = new Intent(loginRegisterationActivity.this, .class); // add class to open different page for testing
                startActivity(homeIntent);
            }
        });

    }

}