package com.collectionagency.collectionagency;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CA_Contact extends AppCompatActivity {

    private static final int PER_REQUEST_CODE = 100;
    Intent intent;
    Button call1, email1, call2, email2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ca_contact);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Contact Us");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        call1 = (Button)findViewById(R.id.btn_call1);
        email1 = (Button)findViewById(R.id.btn_email1);
        call2 = (Button)findViewById(R.id.btn_call2);
        email2 = (Button)findViewById(R.id.btn_email2);

        call1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel: +917874181218"));
                startActivity(intent);
            }
        });

        email1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"mukesh.p.rockers@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "[Collecton Agency]: ");
                i.putExtra(Intent.EXTRA_TEXT   , "Hello! ");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplication(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        call2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel: +917405229128"));
                startActivity(intent);
            }
        });

        email2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"dataniyadharmesh3132@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "[Collecton Agency]: ");
                i.putExtra(Intent.EXTRA_TEXT   , "Hello! ");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplication(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == PER_REQUEST_CODE){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplication(), "Permission is not granted", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
