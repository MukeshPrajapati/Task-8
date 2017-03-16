package com.collectionagency.collectionagency.company;

import android.app.Dialog;
import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.collectionagency.collectionagency.R;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CA_Company_HomeScreen extends ListActivity {

    TextView lb1;
    Button btnUpload;
    ListView lv;
    CA_Company_DBController_Excel controller_excel = new CA_Company_DBController_Excel(this);
    final Context context = this;
    ListAdapter adapter;
    ArrayList<HashMap<String, String>> myList;
    public static final int requestcode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ca_company_home_screen_activity);

        lb1 = (TextView)findViewById(R.id.txtresulttext);
        btnUpload = (Button)findViewById(R.id.ca_company_btn_upload);
        lv = getListView();

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fileintent = new Intent(Intent.ACTION_GET_CONTENT);
                fileintent.setType("gagt/sdf");
                try {
                    startActivityForResult(fileintent, requestcode);
                } catch (ActivityNotFoundException e) {
                    lb1.setText("No activity can handle picking a file. Showing alternatives.");
                }
            }
        });

        myList = controller_excel.getPendingData();

        if (myList.size() != 0) {
            ListView lv = getListView();
            ListAdapter adapter = new SimpleAdapter(CA_Company_HomeScreen.this, myList,
                    R.layout.ca_company_excel_rows, new String[]{"Srno", "Name", "Mobileno"}, new int[]{
                    R.id.excel_company_srno, R.id.excel_company_name, R.id.excel_company_mobno});
            setListAdapter(adapter);
            lb1.setText("");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.ca_company_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.ca_company_cp){

            Intent intent = new Intent(CA_Company_HomeScreen.this,CA_Company_ChangePassword.class);
            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null)
            return;
        switch (requestCode) {
            case requestcode:
                String filepath = data.getData().getPath();
                controller_excel = new CA_Company_DBController_Excel(getApplicationContext());
                SQLiteDatabase db = controller_excel.getWritableDatabase();
                String tableName = "Table_PendingList";
                db.execSQL("delete from " + tableName);
                try {
                    if (resultCode == RESULT_OK) {
                        try {

                            FileReader file = new FileReader(filepath);

                            BufferedReader buffer = new BufferedReader(file);
                            ContentValues contentValues = new ContentValues();
                            String line = "";
                            db.beginTransaction();

                            while ((line = buffer.readLine()) != null) {

                                String[] str = line.split(",", 3);  // defining 3 columns with null or blank field //values acceptance
                                //Id, Company,Name,Price
                                String srno = str[0].toString();
                                String name = str[1].toString();
                                String mobileno = str[2].toString();

                                contentValues.put("Srno", "Srno: " +srno);
                                contentValues.put("Name", "Name: " +name);
                                contentValues.put("Mobileno", "Mobile No: " +mobileno);
                                db.insert(tableName, null, contentValues);
                                lb1.setText("Successfully Updated Database.");
                            }
                            db.setTransactionSuccessful();
                            db.endTransaction();
                        } catch (IOException e) {
                            if (db.inTransaction())
                                db.endTransaction();
                            Dialog d = new Dialog(this);
                            d.setTitle(e.getMessage().toString() + "first");
                            d.show();
                            // db.endTransaction();
                        }
                    } else {
                        if (db.inTransaction())
                            db.endTransaction();
                        Dialog d = new Dialog(this);
                        d.setTitle("Only CSV files allowed");
                        d.show();
                    }
                } catch (Exception ex) {
                    if (db.inTransaction())
                        db.endTransaction();

                    Dialog d = new Dialog(this);
                    d.setTitle(ex.getMessage().toString() + "second");
                    d.show();
                    // db.endTransaction();
                }
        }
        myList= controller_excel.getPendingData();

        if (myList.size() != 0) {
            ListView lv = getListView();
            ListAdapter adapter = new SimpleAdapter(CA_Company_HomeScreen.this, myList,
                    R.layout.ca_company_excel_rows, new String[]{"Srno", "Name", "Mobileno"}, new int[]{
                    R.id.excel_company_srno, R.id.excel_company_name, R.id.excel_company_mobno});
            setListAdapter(adapter);
            lb1.setText("Data Imported");
        }
    }
}