package com.collectionagency.collectionagency.manager;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.collectionagency.collectionagency.R;

import java.util.ArrayList;

public class CA_Manager_Notification_PendingListAdapter extends BaseAdapter {

    private Context context;
    int layoutResourceId;
    ArrayList<CA_Manager_PendingList> pendingLists;


    public  CA_Manager_Notification_PendingListAdapter(Context context, int layoutResourceId, ArrayList<CA_Manager_PendingList> pendingLists)
    {
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.pendingLists = pendingLists;
    }

    @Override
    public int getCount() {
        return pendingLists.size();
    }

    @Override
    public Object getItem(int position) {
        return pendingLists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    static class ViewHolder
    {
        TextView tv_name, srno;
        Button assign, edit, delete;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();
        if (convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.ca_manager_notification_pendinglistadapter,parent,false);
            holder.srno = (TextView)convertView.findViewById(R.id.srno);
            holder.tv_name = (TextView)convertView.findViewById(R.id.name);
            holder.assign = (Button)convertView.findViewById(R.id.btn_assin);
            holder.edit = (Button)convertView.findViewById(R.id.btn_edit);
            holder.delete = (Button)convertView.findViewById(R.id.btn_delete);
            convertView.setTag(holder);
        }

        else {
            holder = (ViewHolder)convertView.getTag();
        }

        final CA_Manager_PendingList list = pendingLists.get(position);

        holder.srno.setText(String.valueOf(list.getSrno()));
        holder.tv_name.setText(list.getPendinglist_item());

        holder.assign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Assign Button: " +position, Toast.LENGTH_SHORT).show();
            }
        });

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Edit Button: " +position, Toast.LENGTH_SHORT).show();
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Delete Button: " +position, Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}