package com.example.servicesaroundme.UtilityFunctions;

import android.content.Intent;
import android.drm.DrmStore;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.servicesaroundme.*;
import com.example.servicesaroundme.CoreCapabilities.homeActivity;
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
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class testActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //variables
    DrawerLayout dl;
    NavigationView nv;
    Toolbar tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        dl = findViewById(R.id.drawer_layout);
        nv = findViewById(R.id.nav_view);
        tb = findViewById(R.id.myToolbar);

        setSupportActionBar(tb);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl,tb,R.string.openNavigation,R.string.closeNavigation);
        dl.addDrawerListener(toggle);
        toggle.syncState();

        nv.setNavigationItemSelectedListener(this);
        nv.setCheckedItem(R.id.menu_home);
    }
    @Override
    public void onBackPressed() {
        if (dl.isDrawerOpen(GravityCompat.START)){
            dl.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent i;
        switch (item.getItemId()){
            case R.id.menu_feedback:
                i = new Intent(testActivity.this, feedbackActivity.class);
                startActivity(i);
                break;
            case R.id.menu_fovourites:
                i = new Intent(testActivity.this, favouritesActivity.class);
                startActivity(i);
                break;
            case R.id.menu_help:
                i = new Intent(testActivity.this, helpActivity.class);
                startActivity(i);
                break;
            case R.id.menu_home:
                i = new Intent(testActivity.this, homeActivity.class);
                startActivity(i);
                break;
            case R.id.menu_inbox:
                i = new Intent(testActivity.this, inboxActivity.class);
                startActivity(i);
                break;
            case R.id.menu_login:
                i = new Intent(testActivity.this, loginRegisterationActivity.class);
                startActivity(i);
                Toast.makeText(this, "LOG IN example", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_logout:
                // logout and then move to login window
                i = new Intent(testActivity.this, loginRegisterationActivity.class);
                startActivity(i);
                Toast.makeText(this, "LOG OUT example", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_orders:
                i = new Intent(testActivity.this, ordersActivity.class);
                startActivity(i);
                break;
            case R.id.menu_preferences:
                i = new Intent(testActivity.this, preferencesActivity.class);
                startActivity(i);
                break;
            case R.id.menu_quote:
                i = new Intent(testActivity.this, quotesActivity.class);
                startActivity(i);
                break;
            case R.id.menu_services_catalogue:
                i = new Intent(testActivity.this, serviceCatalogueActivity.class);
                startActivity(i);
                break;
            case R.id.menu_user_account:
                i = new Intent(testActivity.this, userAccountActivity.class);
                startActivity(i);
                break;
            default:

        }
        dl.closeDrawer(GravityCompat.START);
        return true;
    }
}