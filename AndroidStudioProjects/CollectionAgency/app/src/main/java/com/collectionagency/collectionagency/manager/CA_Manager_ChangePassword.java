package com.collectionagency.collectionagency.manager;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.collectionagency.collectionagency.R;

public class CA_Manager_ChangePassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ca_manager_change_password);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Change Password");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }
}
