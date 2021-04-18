package com.example.servicesaroundme.UtilityFunctions;

import android.app.Activity;
import android.widget.Toolbar;

import com.example.servicesaroundme.R;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

public class toolbarUtil {

    DrawerLayout obj_DrawerLayout;
    NavigationView obj_NavigationView;
    androidx.appcompat.widget.Toolbar obj_Toolbar;

    public androidx.appcompat.widget.Toolbar setupToolbarOnCreate(Activity act){
        androidx.appcompat.widget.Toolbar tb = null;
        obj_DrawerLayout =  act.findViewById(R.id.drawer_layout);
        obj_NavigationView = act.findViewById(R.id.nav_view);
        tb = act.findViewById(R.id.myToolbar);

        return tb;
    }
}
