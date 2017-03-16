package com.collectionagency.collectionagency.company;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.collectionagency.collectionagency.R;

public class CA_Company_ChangePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ca_company_change_password);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Edit Profile");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }
}
