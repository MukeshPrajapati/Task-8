package mukesh.com.task8_quotes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Players on 13/02/2017.
 */
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(layoutResourceId, parent, false);
            holder.success = (TextView)convertView.findViewById(R.id.tv_success_id);
            holder.message = (TextView)convertView.findViewById(R.id.tv_msg_id);
            holder.id = (TextView)convertView.findViewById(R.id.tv_data_id);
            holder.name = (TextView)convertView.findViewById(R.id.tv_name_id);
            convertView.setTag(holder);
        }

        else {
            holder = (ViewHolder) convertView.getTag();
        }

        CategoryPost post = data.get(position);
        holder.success.setText("Success: "+post.getSucess());
        holder.message.setText("Message: "+post.getMsg());
        holder.id.setText("ID: "+post.getId());
        holder.name.setText("Name: "+post.getName());

        return convertView;
    }
}
