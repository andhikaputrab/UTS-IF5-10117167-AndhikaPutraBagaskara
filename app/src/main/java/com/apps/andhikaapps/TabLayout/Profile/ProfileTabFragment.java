package com.apps.andhikaapps.TabLayout.Profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.andhikaapps.R;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    05 may 2020
 */

public class ProfileTabFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_profile, container, false);
    }
}
