package com.example.servicesaroundme.Favourites;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.servicesaroundme.CoreCapabilities.baseActivity;
import com.example.servicesaroundme.R;
import com.example.servicesaroundme.UtilityFunctions.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link favouritesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class favouritesFragment extends Fragment {

    View fragment;
    ViewPager viewPager;
    TabLayout tabLayout;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public favouritesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment favouritesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static favouritesFragment newInstance(String param1, String param2) {
        favouritesFragment fragment = new favouritesFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragment = inflater.inflate(R.layout.fragment_favourites, container, false);


//        tabLayout = fragment.findViewById(R.id.tabLayout);
//        viewPager = fragment.findViewById(R.id.viewPager);

//        tabLayout = getActivity().findViewById(R.id.tabLayout);
//        viewPager = getActivity().findViewById(R.id.viewPager);
        return fragment;
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        setupViewPagerAdapter(viewPager);
//        tabLayout.setupWithViewPager(viewPager);
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//    }
//
//    private void setupViewPagerAdapter(ViewPager viewPager) {
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(),0);
//        viewPagerAdapter.addFragment(new favouritesQuotes(), "QUOTESs");
//        viewPagerAdapter.addFragment(new favouritesServices(), "SERVICESs");
//        viewPagerAdapter.addFragment(new favouritesServiceProviders(), "SERVICE PROVIDERSs");
//        viewPager.setAdapter(viewPagerAdapter);
//    }
}