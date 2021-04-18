package com.example.servicesaroundme.Feedback;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.servicesaroundme.R;
import com.google.android.material.tabs.TabLayout;

public class feedbackActivity extends AppCompatActivity {

    private TabLayout oFeedbackTabLayout;
    private ViewPager oFeedbackViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

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

}