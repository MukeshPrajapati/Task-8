package mukesh.com.task8_quotes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Players on 14/02/2017.
 */
public class CustomListViewAdapter extends ArrayAdapter {
    Context con;
    int layoutResourceId;
    ArrayList<QuotesPost> data = new ArrayList<>();

    public CustomListViewAdapter(Context context, int resource, ArrayList<QuotesPost> objects) {
        super(context, resource, objects);
        this.layoutResourceId = resource;
        this.con = context;
        this.data = objects;
    }

    static class ViewHolder
    {
        TextView id, cat_id, quotes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;

        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(con).inflate(layoutResourceId, parent, false);

            holder.id = (TextView)convertView.findViewById(R.id.tv_id);
            holder.cat_id = (TextView)convertView.findViewById(R.id.tv_cat_id);
            holder.quotes = (TextView)convertView.findViewById(R.id.tv_quote_id);

            convertView.setTag(holder);
        }

        else {
            holder = (ViewHolder) convertView.getTag();
        }

        final QuotesPost p = data.get(position);
        holder.quotes.setText(p.getQuote());

        holder.quotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Third.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                intent.putExtra("Quote", p.getQuote());
                    v.getContext().startActivity(intent);
            }
        });

        return convertView;
    }
}
