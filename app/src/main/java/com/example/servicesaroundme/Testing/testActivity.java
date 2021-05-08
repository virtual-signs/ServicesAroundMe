package com.example.servicesaroundme.Testing;

import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

public class testActivity extends AppCompatActivity  {
    //variables
    DrawerLayout dl;
    NavigationView nv;
    Toolbar tb;


//implements NavigationView.OnNavigationItemSelectedListener

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        dl = findViewById(R.id.drawer_layout);
        nv = findViewById(R.id.nav_view);
        tb = findViewById(R.id.myToolbar);

        setSupportActionBar(tb);

        */
/*------------ Navigation Drawer Menu ----------------*//*


        // Hide and Show items
        Menu menu = nv.getMenu();
        menu.findItem(R.id.menu_logout).setVisible(false);

        nv.bringToFront();
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
*/

}