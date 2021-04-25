package com.example.servicesaroundme.ServiceCatalogue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.servicesaroundme.CoreCapabilities.baseActivity;
import com.example.servicesaroundme.R;

public class serviceCatalogueActivity extends baseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_service_catalogue);

        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflate your activity layout here!
        View contentView = inflater.inflate(R.layout.activity_service_catalogue, null, false);
        drawerLayout.addView(contentView, 0);
    }
}