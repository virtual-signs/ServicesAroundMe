package com.example.servicesaroundme.Favourites;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.servicesaroundme.CoreCapabilities.baseActivity;
import com.example.servicesaroundme.R;
import com.example.servicesaroundme.UtilityFunctions.ViewPagerAdapter;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class favouritesActivity extends baseActivity {

//    private Toolbar toolbar;
//    private TabLayout oFeedbackTabLayout;
//    private ViewPager oFeedbackViewPager;
//
//    private favouritesQuotes favQuotes;
//    private favouritesServices favServices;
//    private favouritesServiceProviders favServiceProviders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_favourites);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflate your activity layout here!
        View contentView = inflater.inflate(R.layout.activity_favourites, null, false);
        drawerLayout.addView(contentView, 0);

//        toolbar = findViewById(R.id.myToolbar);
//        setSupportActionBar(toolbar);
//
//        oFeedbackTabLayout = findViewById(R.id.favouritesTabLayout);
//        oFeedbackViewPager = findViewById(R.id.favouritesViewPager);
//
//        favQuotes = new favouritesQuotes();
//        favServices = new favouritesServices();
//        favServiceProviders = new favouritesServiceProviders();
//
//        oFeedbackTabLayout.setupWithViewPager(oFeedbackViewPager);
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),0);
//        viewPagerAdapter.addFragment(favQuotes, "QUOTESs");
//        viewPagerAdapter.addFragment(favServices, "SERVICESs");
//        viewPagerAdapter.addFragment(favServiceProviders, "SERVICE PROVIDERSs");
//
//        oFeedbackViewPager.setAdapter(viewPagerAdapter);
//
//        oFeedbackTabLayout.getTabAt(0).setIcon(R.drawable.ic_favorites);
//        oFeedbackTabLayout.getTabAt(1).setIcon(R.drawable.ic_favorites);
//        oFeedbackTabLayout.getTabAt(2).setIcon(R.drawable.ic_favorites);
//
//        BadgeDrawable badge = oFeedbackTabLayout.getTabAt(0).getOrCreateBadge();
//        badge.setVisible(true);
//        badge.setNumber(viewPagerAdapter.getCount());
    }
}