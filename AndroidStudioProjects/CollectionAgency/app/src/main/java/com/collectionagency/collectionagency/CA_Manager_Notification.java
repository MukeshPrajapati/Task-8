package com.collectionagency.collectionagency;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.astuetz.PagerSlidingTabStrip;

public class CA_Manager_Notification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ca_manager_notification);

        ViewPager viewPager = (ViewPager)findViewById(R.id.ca_manager_notification_pager);
        viewPager.setAdapter(new CA_Manager_Notification_Adapter(getSupportFragmentManager()));

        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip)findViewById(R.id.tabs);
        tabStrip.setViewPager(viewPager);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Notification");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }
}
