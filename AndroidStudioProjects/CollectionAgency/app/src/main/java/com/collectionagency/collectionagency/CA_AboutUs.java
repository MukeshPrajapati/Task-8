package com.collectionagency.collectionagency;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CA_AboutUs extends AppCompatActivity {

    private TextView about1, about2, about3;

    private String str1 ="             Today there are lots of telecom services that customers are using for their day do day communication. Some are using prepaid while some are using postpaid services. " +
            "The postpaid mobile phone is a mobile phone for which service is provided by a prior arrangement with a mobile network operator. The user in this situation is billed after the fact according to their use of mobile services at the end of each month.";
    private String str2 = "            There are many users who don’t pay amount at regular time, Some are paying half amount or little amount online, Some are just avoid payment, and many more issue in such conditions telecom service company is not going to collect amount from each post paid users individually by going at their doorstep. " +
            "Due to all such problems telecom service companies will assign amount collection work to collection agency.";
    private String str3 = "\u00a9 CollectionAgency 2017";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ca_about_us);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("About Us");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        about1 = (TextView)findViewById(R.id.tv_about1);
        about1.setText(str1);

        about2 = (TextView)findViewById(R.id.tv_about2);
        about2.setText(str2);

        about3 = (TextView)findViewById(R.id.tv_about3);
        about3.setText(str3);
    }
}
