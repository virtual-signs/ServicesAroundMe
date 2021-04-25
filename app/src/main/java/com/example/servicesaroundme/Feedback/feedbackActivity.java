package com.example.servicesaroundme.Feedback;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.servicesaroundme.CoreCapabilities.baseActivity;
import com.example.servicesaroundme.CoreCapabilities.homeActivity;
import com.example.servicesaroundme.Favourites.favouritesActivity;
import com.example.servicesaroundme.Help.helpActivity;
import com.example.servicesaroundme.Inbox.inboxActivity;
import com.example.servicesaroundme.MyAccount.loginRegisterationActivity;
import com.example.servicesaroundme.OrderPurchases.ordersActivity;
import com.example.servicesaroundme.PreferencesUserMgmt.preferencesActivity;
import com.example.servicesaroundme.QuotesMgmt.quotesActivity;
import com.example.servicesaroundme.R;
import com.example.servicesaroundme.ServiceCatalogue.serviceCatalogueActivity;
import com.example.servicesaroundme.Testing.testMapsActivity;
import com.example.servicesaroundme.UtilityFunctions.ViewPagerAdapter;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class feedbackActivity extends baseActivity implements NavigationView.OnNavigationItemSelectedListener {

//    private Toolbar toolbar;
//    private DrawerLayout drawerLayout;
//    private NavigationView navigationView;
//
//    private TabLayout tabLayout;
//    private ViewPager viewPager;
//
//    private feedbackOverallRating fbOverallRating;
//    private feedbackReceived fbReceived;
//    private feedbackProvided fbProvided;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_feedback);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //inflate your activity layout here!
        View contentView = inflater.inflate(R.layout.activity_feedback, null, false);
        drawerLayout.addView(contentView, 0);

        // find a handle for gui elements used in this class
//        toolbar = findViewById(R.id.myToolbar);
//        tabLayout = findViewById(R.id.tabLayout);
//        viewPager = findViewById(R.id.viewPager);
//        drawerLayout = findViewById(R.id.drawer_layout);
//        navigationView = findViewById(R.id.nav_view);

//        // --------------------------------- Setting up Toolbar ------------------------//
//        setSupportActionBar(toolbar);
//        onCreateSetupToolbar();
//        /* ===================== Drawer/Navigation ==================== */
//        navigationView.bringToFront();
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openNavigation, R.string.closeNavigation);
//        drawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//        navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) this);
//        navigationView.setCheckedItem(R.id.menu_home);
//        // ------------------------------ Setting up Tabs -------------------------------//
//
//        fbOverallRating = new feedbackOverallRating();
//        fbReceived = new feedbackReceived();
//        fbProvided = new feedbackProvided();
//
//        tabLayout.setupWithViewPager(viewPager);
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
//
//        viewPagerAdapter.addFragment(fbOverallRating, "Overall Rating");
//        viewPagerAdapter.addFragment(fbReceived, "Received");
//        viewPagerAdapter.addFragment(fbProvided, "Provided");
//
//        viewPager.setAdapter(viewPagerAdapter);
//
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_feedback);
//        tabLayout.getTabAt(1).setIcon(R.drawable.ic_feedback);
//        tabLayout.getTabAt(2).setIcon(R.drawable.ic_feedback);
//
//        BadgeDrawable badge = tabLayout.getTabAt(0).getOrCreateBadge();
//        badge.setVisible(true);
//        badge.setNumber(viewPagerAdapter.getCount());
    }
    // =============== FUNCTIONS FOR TOOLBAR ========================
    public void onCreateSetupToolbar(){
        //Variables for Drawer/Navigation View
    }

//    @Override
//    public void onBackPressed() {
//        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        Intent i;
//        switch (item.getItemId()) {
//            case R.id.menu_feedback:
//                i = new Intent(feedbackActivity.this, feedbackActivity.class);
//                startActivity(i);
//                break;
//            case R.id.menu_fovourites:
//                i = new Intent(feedbackActivity.this, favouritesActivity.class);
//                startActivity(i);
//                break;
//            case R.id.menu_help:
//                i = new Intent(feedbackActivity.this, helpActivity.class);
//                startActivity(i);
//                break;
//            case R.id.menu_home:
//                i = new Intent(feedbackActivity.this, homeActivity.class);
//                startActivity(i);
//                break;
//            case R.id.menu_inbox:
//                i = new Intent(feedbackActivity.this, inboxActivity.class);
//                startActivity(i);
//                break;
//            case R.id.menu_login:
//                i = new Intent(feedbackActivity.this, loginRegisterationActivity.class);
//                startActivity(i);
//                Toast.makeText(this, "LOG IN example", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.menu_logout:
//                // logout and then move to login window
//                FirebaseAuth.getInstance().signOut();
//                startActivity(new Intent(feedbackActivity.this, loginRegisterationActivity.class));
////                i = new Intent(homeActivity.this, loginRegisterationActivity.class);
////                startActivity(i);
//                Toast.makeText(this, "LOG OUT example", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.menu_orders:
//                i = new Intent(feedbackActivity.this, ordersActivity.class);
//                startActivity(i);
//                break;
//            case R.id.menu_preferences:
//                i = new Intent(feedbackActivity.this, preferencesActivity.class);
//                startActivity(i);
//                break;
//            case R.id.menu_quote:
//                i = new Intent(feedbackActivity.this, quotesActivity.class);
//                startActivity(i);
//                break;
//            case R.id.menu_services_catalogue:
//                i = new Intent(feedbackActivity.this, serviceCatalogueActivity.class);
//                startActivity(i);
//                break;
//            case R.id.menu_user_account:
////                i = new Intent(homeActivity.this, userAccountActivity.class);
//                i = new Intent(feedbackActivity.this, testMapsActivity.class);
//                startActivity(i);
//                break;
//            default:
//
//        }
//        drawerLayout.closeDrawer(GravityCompat.START);
//        return true;
//    }
}