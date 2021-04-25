package com.example.servicesaroundme.UtilityFunctions;

import android.app.Activity;
import android.widget.Toolbar;

import com.example.servicesaroundme.R;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

public class toolbarUtil {

    DrawerLayout obj_DrawerLayout;
    NavigationView obj_NavigationView;
    androidx.appcompat.widget.Toolbar obj_Toolbar;

    public androidx.appcompat.widget.Toolbar setupToolbarOnCreate(Activity act){
        androidx.appcompat.widget.Toolbar tb = null;
        obj_DrawerLayout =  act.findViewById(R.id.drawer_layout);
        obj_NavigationView = act.findViewById(R.id.nav_view);
        tb = act.findViewById(R.id.toolbar);
        return tb;
    }
//    // =============== FUNCTIONS FOR TOOLBAR ========================
//    public void onCreateSetupToolbar(){
//        //Variables for Drawer/Navigation View
//        //DrawerLayout obj_DrawerLayout;
//        //NavigationView obj_NavigationView;
//        //Toolbar obj_Toolbar;
//
//        /* ===================== Drawer/Navigation ==================== */
//        obj_DrawerLayout = findViewById(R.id.drawer_layout);
//        obj_NavigationView = findViewById(R.id.nav_view);
//        obj_Toolbar = findViewById(R.id.myToolbar);
//
//        setSupportActionBar(obj_Toolbar);
//
//        obj_NavigationView.bringToFront();
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, obj_DrawerLayout, obj_Toolbar, R.string.openNavigation, R.string.closeNavigation);
//        obj_DrawerLayout.addDrawerListener(toggle);
//        toggle.syncState();
//
//        obj_NavigationView.setNavigationItemSelectedListener(this);
//        obj_NavigationView.setCheckedItem(R.id.menu_home);
//    }
}
