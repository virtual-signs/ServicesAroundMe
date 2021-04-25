package com.example.servicesaroundme.CoreCapabilities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import static android.widget.Toast.LENGTH_LONG;

public class baseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    protected DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageView homeImage, userImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        navigationView.bringToFront();

        View navigationalViewHeader = navigationView.getHeaderView(0);
        homeImage = navigationalViewHeader.findViewById(R.id.menu_home_img);
        userImage = navigationalViewHeader.findViewById(R.id.menu_user_account_img);

        homeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // take me HOME
                Intent i = new Intent(baseActivity.this, homeActivity.class);
                startActivity(i);
            }
        });
        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // take me to My ACCOUNT
                Intent i = new Intent(baseActivity.this, userAccountActivity.class);
                startActivity(i);
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openNavigation, R.string.closeNavigation);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
//        navigationView.setCheckedItem(R.id.menu_home);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent i;
        switch (item.getItemId()) {

            case R.id.menu_feedback:
                i = new Intent(this, feedbackActivity.class);
                startActivity(i);
                break;
            case R.id.menu_fovourites:
                i = new Intent(this, favouritesActivity.class);
                startActivity(i);
                break;
            case R.id.menu_help:
                i = new Intent(this, helpActivity.class);
                startActivity(i);
                break;
//            case R.id.menu_home:
//                i = new Intent(this, homeActivity.class);
//                startActivity(i);
//                break;
            case R.id.menu_inbox:
                i = new Intent(this, inboxActivity.class);
                startActivity(i);
                break;
            case R.id.menu_login:
                i = new Intent(this, loginRegisterationActivity.class);
                startActivity(i);
                Toast.makeText(this, "LOG IN example", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_logout:
                // logout and then move to login window
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(this, loginRegisterationActivity.class));
//                i = new Intent(homeActivity.this, loginRegisterationActivity.class);
//                startActivity(i);
                Toast.makeText(this, "LOG OUT example", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_orders:
                i = new Intent(this, ordersActivity.class);
                startActivity(i);
                break;
            case R.id.menu_preferences:
                i = new Intent(this, preferencesActivity.class);
                startActivity(i);
                break;
            case R.id.menu_quote:
                i = new Intent(this, quotesActivity.class);
                startActivity(i);
                break;
            case R.id.menu_services_catalogue:
                i = new Intent(this, serviceCatalogueActivity.class);
                startActivity(i);
                break;
//            case R.id.menu_user_account:
//                i = new Intent(this, userAccountActivity.class);
//                startActivity(i);
//                break;
            case R.id.menu_test:
                i = new Intent(this, userAccountActivity.class);
                startActivity(i);
                break;
            default:
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}