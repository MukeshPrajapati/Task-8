package com.collectionagency.collectionagency.company;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class CA_Company_DBController_Excel extends SQLiteOpenHelper {

    private static final String LOGCAT = null;

    public CA_Company_DBController_Excel(Context applicationcontext) {
        super(applicationcontext, "CollectionAgency.db", null, 1);  // creating DATABASE
        Log.d(LOGCAT, "Created");
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String query;
        query = "CREATE TABLE IF NOT EXISTS Table_PendingList ( Id INTEGER PRIMARY KEY, Srno TEXT, Name TEXT, Mobileno TEXT)";
        database.execSQL(query);
    }


    @Override
    public void onUpgrade(SQLiteDatabase database, int version_old,
                          int current_version) {
        String query;
        query = "DROP TABLE IF EXISTS Table_PendingList";
        database.execSQL(query);
        onCreate(database);
    }

    public ArrayList<HashMap<String, String>> getPendingData() {

        ArrayList<HashMap<String, String>> proList;
        proList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM Table_PendingList";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                //Id, Company,Name,Price
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("Id", cursor.getString(0));
                map.put("Srno",cursor.getString(1));
                map.put("Name", cursor.getString(2));
                map.put("Mobileno", cursor.getString(3));
                proList.add(map);
            } while (cursor.moveToNext());
        }

        return proList;
    }
}