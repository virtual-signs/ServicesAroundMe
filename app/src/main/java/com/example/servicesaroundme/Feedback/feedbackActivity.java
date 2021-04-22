package com.example.servicesaroundme.Feedback;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

import com.example.servicesaroundme.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

//fragment_favourites_quotes
//        fragment_favourites_service_providers
//        fragment_favourites_services

public class feedbackActivity extends AppCompatActivity {

    private TabLayout oFeedbackTabLayout;
    private ViewPager oFeedbackViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        // --------------------------------- Setting up Toolbar ------------------------//
        // Find the toolbar view inside the activity layout
        Toolbar toolbar = (Toolbar) findViewById(R.id.myToolbar);
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);

        // ------------------------------ Setting up Tabs -------------------------------//
        oFeedbackTabLayout = findViewById(R.id.feedbackTab);
        oFeedbackViewPager = findViewById(R.id.feedbackViewPager);

        oFeedbackTabLayout.addTab(oFeedbackTabLayout.newTab().setText("Overall Rating"));
        oFeedbackTabLayout.addTab(oFeedbackTabLayout.newTab().setText("Received"));
        oFeedbackTabLayout.addTab(oFeedbackTabLayout.newTab().setText("Provided"));

        oFeedbackViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(),FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        feedbackOverallRating overallRating = new feedbackOverallRating();
                        return  overallRating;
                    case 1:
                        feedbackReceived received = new feedbackReceived();
                        return received;
                    case 2:
                        feedbackProvided provided = new feedbackProvided();
                        return  provided;
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return oFeedbackTabLayout.getTabCount();
            }
        });
        oFeedbackTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                oFeedbackViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    // =============== FUNCTIONS FOR TOOLBAR ========================
    public void onCreateSetupToolbar(){
        //Variables for Drawer/Navigation View
        DrawerLayout obj_DrawerLayout;
        NavigationView obj_NavigationView;
        Toolbar obj_Toolbar;

        /* ===================== Drawer/Navigation ==================== */
        obj_DrawerLayout = findViewById(R.id.drawer_layout);
        obj_NavigationView = findViewById(R.id.nav_view);
        obj_Toolbar = findViewById(R.id.myToolbar);

        setSupportActionBar(obj_Toolbar);

        obj_NavigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, obj_DrawerLayout, obj_Toolbar, R.string.openNavigation, R.string.closeNavigation);
        obj_DrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        obj_NavigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
        obj_NavigationView.setCheckedItem(R.id.menu_home);
    }

}