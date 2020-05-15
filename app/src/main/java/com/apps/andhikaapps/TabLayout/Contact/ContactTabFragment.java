package com.apps.andhikaapps.TabLayout.Contact;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.andhikaapps.R;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    15 May 2020
 */

public class ContactTabFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_tab_contact, container, false);

        return root;
    }
}
