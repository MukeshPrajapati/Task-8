package mukesh.com.task9;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomGridViewAdapter extends ArrayAdapter<CategoryPost> {
    private Context context;
    private int layoutResourceId;
    private ArrayList<CategoryPost> data = new ArrayList<CategoryPost>();
    private Fragment getquoteFrag;

    public CustomGridViewAdapter(Context context, int resource, ArrayList<CategoryPost> objects) {
        super(context, resource, objects);
        this.layoutResourceId = resource;
        this.context = context;
        this.data = objects;
    }
    static class ViewHolder
    {
        TextView success, message, id, name;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(layoutResourceId, parent, false);
            holder.id = (TextView)convertView.findViewById(R.id.tv_data_id);
            holder.name = (TextView)convertView.findViewById(R.id.tv_name_id);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        final CategoryPost post = data.get(position);
        holder.name.setText(post.getName());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                getquoteFrag = new GetQuoteFragment();

                FragmentManager quote_fm = ((MainActivity)context).getSupportFragmentManager();
                FragmentTransaction quote_ft = quote_fm.beginTransaction();
                bundle.putInt("pos", post.getId());
                getquoteFrag.setArguments(bundle);
                quote_ft.replace(R.id.ll_id, getquoteFrag);
                quote_ft.addToBackStack(null);
                quote_ft.commit();
            }
        });
        return convertView;
    }
}