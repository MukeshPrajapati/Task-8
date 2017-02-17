package mukesh.com.task9;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomGridViewAdapter extends ArrayAdapter<CategoryPost> {

    Context context;
    int layoutResourceId;
    ArrayList<CategoryPost> data = new ArrayList<CategoryPost>();

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
        /*holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), GetQuotes.class);
                intent.putExtra("pos", post.getId());
                context.startActivity(intent);
            }
        });*/
        return convertView;
    }
}
