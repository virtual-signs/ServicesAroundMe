package com.example.servicesaroundme.ServiceCatalogue;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.servicesaroundme.PreferencesUserMgmt.preferencesApp;
import com.example.servicesaroundme.PreferencesUserMgmt.preferencesEmail;
import com.example.servicesaroundme.PreferencesUserMgmt.preferencesNetwork;
import com.example.servicesaroundme.R;
import com.example.servicesaroundme.UtilityFunctions.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link serviceCatalogue#newInstance} factory method to
 * create an instance of this fragment.
 */
public class serviceCatalogue extends Fragment {
    private View fragment;
    private ViewPager viewPager;
    private TabLayout tabLayout;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public serviceCatalogue() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment serviceCatalogueFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static serviceCatalogue newInstance(String param1, String param2) {
        serviceCatalogue fragment = new serviceCatalogue();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragment = inflater.inflate(R.layout.fragment_service_catalogue, container, false);
        tabLayout = fragment.findViewById(R.id.tabLayout);
        viewPager = (ViewPager)fragment.findViewById(R.id.viewPager);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tabLayout.setupWithViewPager(viewPager);
        setupViewPagerAdapter(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) { }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }

    private void setupViewPagerAdapter(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager(),0);
        viewPagerAdapter.addFragment(new serviceCatalogueList(), "Services");
        viewPagerAdapter.addFragment(new serviceCatalogueSettings(), "Settings");
        viewPager.setAdapter(viewPagerAdapter);
    }
}