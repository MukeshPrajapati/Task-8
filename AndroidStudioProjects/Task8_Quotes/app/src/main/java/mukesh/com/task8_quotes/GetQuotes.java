package mukesh.com.task8_quotes;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GetQuotes extends AppCompatActivity {
    private int cat_id;
    private ListView listView;
    private CustomListViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_quotes);

        cat_id = getIntent().getIntExtra("pos",-1);
        new Quotes().execute("http://rapidans.esy.es/test/getquotes.php?cat_id="+cat_id);
    }

    class Quotes extends AsyncTask<String,Void,String>{

        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(GetQuotes.this);
            dialog.setMessage("Loading...");
            dialog.setCancelable(false);
            dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection;
            try {
                URL url = new URL(params[0]);
                try {
                    connection = (HttpURLConnection)url.openConnection();
                    connection.connect();

                    InputStream stream = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

                    StringBuffer buffer = new StringBuffer();
                    String line = "";

                    while ((line =reader.readLine())!= null){
                        buffer.append(line);
                    }
                    String bufferString = buffer.toString();
                    return  bufferString;

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {

            if (dialog.isShowing()){
                dialog.dismiss();
            }

            ArrayList<QuotesPost> arrayList = new ArrayList<>();
            super.onPostExecute(s);
            try {
                JSONObject rootObject = new JSONObject(s);
                JSONArray dataObject = rootObject.getJSONArray("data");
                for (int i = 0; i <dataObject.length() ; i++) {

                    JSONObject obj = dataObject.getJSONObject(i);
                    QuotesPost quotesPost = new QuotesPost();

                    int id = obj.getInt("id");
                    int cat_id = obj.getInt("cat_id");
                    String quotes = obj.getString("quotes");

                    String TAG = "JSON Parsing";
                    Log.d(TAG,"ID: " +id);
                    Log.d(TAG, "cat_id: "+cat_id);
                    Log.d(TAG, "Quotes: "+quotes);

                    quotesPost.setId(id);
                    quotesPost.setCat_id(cat_id);
                    quotesPost.setQuote(quotes);

                    arrayList.add(quotesPost);
                    }
                } catch (JSONException e) {
                e.printStackTrace();
            }

            listView = (ListView)findViewById(R.id.listview_id);
            adapter = new CustomListViewAdapter(GetQuotes.this, R.layout.listview_quotes, arrayList);
            listView.setAdapter(adapter);
        }
    }
}
