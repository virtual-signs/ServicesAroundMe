package com.example.servicesaroundme.Favourites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import com.example.servicesaroundme.R;

public class favouritesActivity extends AppCompatActivity {

    private Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);

        tb = findViewById(R.id.myToolbar);
        setSupportActionBar(tb);


    }
}