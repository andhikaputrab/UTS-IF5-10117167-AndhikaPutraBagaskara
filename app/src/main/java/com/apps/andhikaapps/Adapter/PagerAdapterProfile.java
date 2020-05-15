package com.apps.andhikaapps.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.apps.andhikaapps.TabLayout.About.AboutTabFragment;
import com.apps.andhikaapps.TabLayout.Contact.ContactTabFragment;
import com.apps.andhikaapps.TabLayout.FindMe.FindMeTabFragment;
import com.apps.andhikaapps.TabLayout.Profile.ProfileTabFragment;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    15 May 2020
 */

public class PagerAdapterProfile extends FragmentStatePagerAdapter {

    private int number_tabs;

    public PagerAdapterProfile(@NonNull FragmentManager fm, int number_tabs) {
        super(fm);
        this.number_tabs = number_tabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 :
                return new ProfileTabFragment();
            case 1 :
                return new ContactTabFragment();
            case 2 :
                return new FindMeTabFragment();
            case 3 :
                return new AboutTabFragment();
            default :
                return null;
        }
    }

    @Override
    public int getCount() {
        return number_tabs;
    }
}
