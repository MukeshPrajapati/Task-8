package mukesh.com.task8_quotes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Third extends AppCompatActivity {
    private String id;
    private TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        id = getIntent().getStringExtra("Quote");
        t1 = (TextView)findViewById(R.id.quote);
        t1.setText(id);
    }
}
