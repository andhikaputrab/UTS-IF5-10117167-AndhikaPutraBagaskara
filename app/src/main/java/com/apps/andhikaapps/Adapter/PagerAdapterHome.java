package com.apps.andhikaapps.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.apps.andhikaapps.TabLayout.Interest.InterestTabFragment;
import com.apps.andhikaapps.TabLayout.Profile.ProfileTabFragment;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    04 May 2020
 */

public class PagerAdapterHome extends FragmentStatePagerAdapter {

    private int number_tabs;

    public PagerAdapterHome(@NonNull FragmentManager fm, int number_tabs) {
        super(fm);
        this.number_tabs = number_tabs;
    }

    // Mengembalikan fragment yang terkait dengan posisi tertentu
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return new ProfileTabFragment();
            case 1 :
                return new InterestTabFragment();
            default :
                return null;
        }
    }

    // Mengembalikan jumlah tampilan yang tersedia
    @Override
    public int getCount() {
        return number_tabs;
    }
}
