package com.collectionagency.collectionagency;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class CA_Manager_Notification_PendingListAdapter extends ArrayAdapter {

    private Context context;
    private int layoutResourceId;

    private int[] srno;
    private String name[];
    private String area[];


    public CA_Manager_Notification_PendingListAdapter(Context context, int resource, int[] srno, String name[], String area[] ) {
        super(context, resource);

        this.context = context;
        this.layoutResourceId = resource;
        this.srno = srno;
        this.name = name;
        this.area = area;
    }

    class ViewHolder
    {
        TextView tv_srno, tv_name, tv_area;
        Button assign, edit, delete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();
        if(convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(layoutResourceId, parent,false);

            holder.tv_srno = (TextView)convertView.findViewById(R.id.srno);
            holder.tv_name = (TextView)convertView.findViewById(R.id.name);
            holder.tv_area = (TextView)convertView.findViewById(R.id.area);
            holder.assign = (Button)convertView.findViewById(R.id.btn_assin);
            holder.edit = (Button)convertView.findViewById(R.id.btn_edit);
            holder.delete = (Button)convertView.findViewById(R.id.btn_delete);
            convertView.setTag(holder);
        }

        else {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.tv_srno.setText(srno[position]);
        holder.tv_name.setText(name[position]);
        holder.tv_area.setText(area[position]);
        return convertView;
    }
}