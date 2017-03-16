package com.collectionagency.collectionagency.manager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CA_Manager_Notification_Adapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Leave", "Pending List", "Paid List" };

    public CA_Manager_Notification_Adapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CA_Manager_Notification_Leave();
            case 1:
                return new CA_Manager_Notification_PendingList();
            case 2:
                return new CA_Manager_Notification_Paidlist();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
