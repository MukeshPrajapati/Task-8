package com.collectionagency.collectionagency.agent;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.DatePicker;
import android.widget.TextView;

import com.collectionagency.collectionagency.R;

import org.json.JSONObject;

import java.util.Calendar;

public class CA_Agent_Apply_Leave extends AppCompatActivity {
    private DatePicker datePicker;
    public static TextView SelectedDateView;
    public static TextView SelectedDateView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ca_agent_apply_leave);
        SelectedDateView = (TextView)findViewById(R.id.selected_date_from);
        SelectedDateView1 = (TextView)findViewById(R.id.selected_date_to);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Apply Leave");
    }


   public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

       @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);

        }

       /*@Override
       public Dialog onCreateDialog1(Bundle savedInstanceState) {
           // Use the current date as the default date in the picker
           final java.util.Calendar c = java.util.Calendar.getInstance();

           int year1 = c.get(java.util.Calendar.YEAR);
           int month1 = c.get(java.util.Calendar.MONTH);
           int day1 = c.get(java.util.Calendar.DAY_OF_MONTH);

           // Create a new instance of DatePickerDialog and return it
           return new DatePickerDialog(getActivity(), this, year1, month1, day1);
       }*/

        public void onDateSet(DatePicker view, int year, int month, int day) {
            SelectedDateView.setText("Selected Date : " + (month + 1) + "-" + day + "-" + year);
            SelectedDateView1.setText("Selected Date : " + (month + 1) + "-" + day + "-" + year);
        }

       /*@Override

       public void onDateSet(DatePicker view, int year1, int month1, int day1) {
           SelectedDateView1.setText("Selected Date : " + (month1 + 1) + "-" + day1 + "-" + year1);
       }*/
    }

   /* public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
*/
    public void showDatePickerDialog1(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }


}
