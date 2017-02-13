package mukesh.com.task8_quotes;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

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

public class MainActivity extends AppCompatActivity {
    private ArrayList<CategoryPost> arrayList = new ArrayList<CategoryPost>();
    private GridView gridView;
    private CustomGridViewAdapter adapter;

    private static final String TAG = "JSON Parsing ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }*/
        new Category().execute("http://rapidans.esy.es/test/getallcat.php");
    }

    class Category extends AsyncTask<String,Void,String>{
/*

        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog=new ProgressDialog(MainActivity.this);
            dialog.setMessage("Please Wait While Loading...");
            dialog.setCancelable(false);
            dialog.show();
        }
*/

        @Override
        protected String doInBackground(String... params) {

            HttpURLConnection connection;
            try {
                //URL url = new URL("http://rapidans.esy.es/test/getallcat.php");
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
            super.onPostExecute(s);
            try {
                JSONObject rootObject = new JSONObject(s);
                int success = rootObject.getInt("success");
                String msg = rootObject.getString("message");

                Log.d(TAG,"ID:" +success);
                Log.d(TAG,"ID:" +msg);

                CategoryPost post = new CategoryPost();

                post.setSucess(success);
                post.setMsg(msg);

                JSONArray dataObject = rootObject.getJSONArray("data");
                for (int i = 0; i <dataObject.length() ; i++) {

                    JSONObject idObject = dataObject.getJSONObject(i);
                    String id = idObject.getString("id");
                    String name = idObject.getString("name");

                    Log.d(TAG,"ID:" +id);
                    Log.d(TAG,"Name:" +name);
                    post.setId(id);
                    post.setName(name);

                    arrayList.add(post);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

            gridView = (GridView)findViewById(R.id.grid_id);
            adapter = new CustomGridViewAdapter(MainActivity.this,R.layout.category_row,arrayList);
            gridView.setAdapter(adapter);
        }
    }
}