package com.apps.andhikaapps.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.apps.andhikaapps.TabLayout.Daily.DailyTabFragment;
import com.apps.andhikaapps.TabLayout.FriendList.FriendListTabFragment;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    07 May 2020
 */

public class PagerAdapterDaily extends FragmentStatePagerAdapter {

    private int number_tabs;

    public PagerAdapterDaily(@NonNull FragmentManager fm, int number_tabs) {
        super(fm);
        this.number_tabs = number_tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new DailyTabFragment();
            case 1:
                return new FriendListTabFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return number_tabs;
    }
}
