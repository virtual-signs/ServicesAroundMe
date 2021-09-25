package com.example.servicesaroundme.UtilityFunctions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.util.ArrayList;

import androidx.annotation.RequiresApi;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

public class Global {
    // STATIC VARIABLES
    static boolean locationPermission = false;
    static ArrayList<MarkerOptions> markersArray = new ArrayList<>();
    static String myUserID = null;

    // GETTER AND SETTER Functions
    public static boolean getLocationPermissionGranted(){
        return locationPermission;
    }
    public static void setLocationPermission(boolean locationPermission) { Global.locationPermission = locationPermission; }
    public static ArrayList<MarkerOptions> getMarkerData(){return markersArray;}
    public static void setMarkerData(ArrayList<MarkerOptions> markers){markersArray = markers;}
    public static String getMyUserID() {return myUserID;}
    public static void setMyUserID(String myUserID) {Global.myUserID = myUserID;}

// Other Global Functions Implementations

    public static void drawMarkersAroundMe(GoogleMap googleMap){
        ArrayList<MarkerOptions> tmpMarkerData = refreshMarkerList();
        for(int i = 0 ; i < tmpMarkerData.size() ; i++) {
            googleMap.addMarker(tmpMarkerData.get(i));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(tmpMarkerData.get(i).getPosition(),5));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tmpMarkerData.get(i).getPosition(),5));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private static ArrayList<MarkerOptions> refreshMarkerList() {
        ArrayList<MarkerOptions> tmpMarkerData = new ArrayList<MarkerOptions>();
        // Populate/refresh locations of all users/providers from google database or Firebase using tmpMarkerData

        // for testing just populate with random values using for loop - delete this for loop once implementation is complete
        for (int i = 0; i < 100; i++) {
            MarkerOptions mo = new MarkerOptions();
            double positionLatitude = 51.395000;
            positionLatitude += (double)(i*((double)1/100));
            Double.sum(positionLatitude,(double)(i*((double)1/100)));
            double positionLongitude = -0.254100;
            LatLng latLng = new LatLng(positionLatitude,positionLongitude);

            mo.position(latLng).title("Decoy" + i);
            mo.snippet("snippet");
            mo.anchor(0.5f,0.5f);
            // icon will be different for user, and service provider
            mo.icon(null);
            tmpMarkerData.add(mo);
        }
        setMarkerData(tmpMarkerData);
        return getMarkerData();
    }

    public void checkMapsPermissions(Context context, Activity activity){
        Dexter.withContext(context).withPermission(ACCESS_FINE_LOCATION).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                Toast.makeText(context, "PERMISSION GRANTED", Toast.LENGTH_SHORT).show();
                Global.setLocationPermission(true);
            }
            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                Intent i = new Intent();
                i.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", activity.getPackageName(), "");
                i.setData(uri);
                context.startActivity(i);
            }
            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }
        }).check();
    }

    // Delete this inner class once marker around the current location are populated ok
//    public static class markerData {
//        long userId;
//        double positionLatitude;
//        double positionLongitude;
//        float anchorParam1;
//        float anchorParam2;
//        String title;
//        String snippet;
//        int iconResID;
//        public markerData(long userId, double positionLatitude, double positionLongitude, float anchorParam1, float anchorParam2, String title, String snippet, int iconResID){
//            this.userId = userId;
//            this.positionLatitude = positionLatitude;
//            this.positionLongitude = positionLongitude;
//            this.anchorParam1 = anchorParam1;
//            this.anchorParam2 = anchorParam2;
//            this.title = title;
//            this.snippet = snippet;
//            this.iconResID = iconResID;
//        }
//    }
}
