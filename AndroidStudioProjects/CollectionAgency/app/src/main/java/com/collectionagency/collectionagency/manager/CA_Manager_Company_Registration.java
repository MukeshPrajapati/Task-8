package com.collectionagency.collectionagency.manager;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.collectionagency.collectionagency.R;

public class CA_Manager_Company_Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ca_manager_company_registration);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Company Registration");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }
}
