package com.collectionagency.collectionagency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class CA_Manager_Notification_PendingList extends Fragment {

    View view;
    ListView listView;
    CA_Manager_Notification_PendingListAdapter adapter;

/*
    int srno[] = getResources().getIntArray(R.array.agent_srno);
    String name[] = getResources().getStringArray(R.array.agent_names);
    String area[] = getResources().getStringArray(R.array.agent_area);
*/
    int srno[] = new int[]{1,2,3};
    String name[] = new String[]{"Sehwag, Sachin, Virat"};
    String area[] = new String[]{"New Ranip, Wadaj, New Ranip"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.ca_manager_notification_pendinglist, container, false);

        listView = (ListView)view.findViewById(R.id.lv_pendinglist);
        adapter = new CA_Manager_Notification_PendingListAdapter(getActivity(),R.layout.ca_manager_notification_pendinglistadapter, srno, name, area);
        listView.setAdapter(adapter);
        return view;
    }
}