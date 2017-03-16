package com.collectionagency.collectionagency.manager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.collectionagency.collectionagency.R;

import java.util.ArrayList;

public class CA_Manager_Notification_PendingList extends Fragment {

    View view;
    ListView listView;
    CA_Manager_Notification_PendingListAdapter adapter;

    String name[] = new String[]{"Sehwag", "Sachin", "Viraaat"};
    Integer srno[] = new Integer[]{1,2,3};
/*
    int srno[] = getResources().getIntArray(R.array.agent_srno);
    String name[] = getResources().getStringArray(R.array.agent_names);
    String area[] = getResources().getStringArray(R.array.agent_area);
*/

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final ArrayList<CA_Manager_PendingList> pendingLists = new ArrayList<>();


        view = inflater.inflate(R.layout.ca_manager_notification_pendinglist, container, false);

        for (int i = 0; i < name.length ; i++) {

            CA_Manager_PendingList item = new CA_Manager_PendingList(name[i], srno[i]);
            pendingLists.add(item);

            /*ListView listView = (ListView)view.findViewById(R.id.lv_pendinglist);
            CA_Manager_Notification_PendingListAdapter adapter = new CA_Manager_Notification_PendingListAdapter(getActivity(),R.layout.ca_manager_notification_pendinglistadapter, pendingLists);
            listView.setItemsCanFocus(false);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Toast.makeText(getActivity(), "List View Clicked:"+ position,
                            Toast.LENGTH_SHORT).show();
                }
            });*/
        }

        ListView listView = (ListView)view.findViewById(R.id.lv_pendinglist);
        CA_Manager_Notification_PendingListAdapter adapter = new CA_Manager_Notification_PendingListAdapter(getActivity(),R.layout.ca_manager_notification_pendinglistadapter, pendingLists);
        listView.setItemsCanFocus(false);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getActivity(), "List View Clicked:"+ position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}