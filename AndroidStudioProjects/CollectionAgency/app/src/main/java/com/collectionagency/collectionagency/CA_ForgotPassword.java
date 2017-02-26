package com.collectionagency.collectionagency;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CA_ForgotPassword extends AppCompatActivity {

    private Fragment forgotpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ca_forgot_password);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Forgot Password");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        forgotpassword = new CA_Frag_ForgotPassword();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frag_forgotpassword,forgotpassword);
        ft.commit();
    }
}
