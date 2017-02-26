package com.collectionagency.collectionagency;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Fragment frag_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag_login = new CA_Login_MainActivity();

        FragmentManager frag_login_manager = getSupportFragmentManager();
        FragmentTransaction frag_login_transcation = frag_login_manager.beginTransaction();
        frag_login_transcation.replace(R.id.ca_layout_login, frag_login);
        frag_login_transcation.commit();
    }
}
