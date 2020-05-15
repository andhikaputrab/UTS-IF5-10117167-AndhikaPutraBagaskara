package com.apps.andhikaapps.TabLayout.Interest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.andhikaapps.Adapter.InterestListAdapter;
import com.apps.andhikaapps.Model.ModelInterest;
import com.apps.andhikaapps.R;

import java.util.ArrayList;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    06 may 2020
 */

public class InterestTabFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View tab = inflater.inflate(R.layout.fragment_tab_interest, container, false);

        final RecyclerView recyclerView = tab.findViewById(R.id.recycler_view_interest);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(requireActivity().getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<ModelInterest> ArrayInterest = InterestData.prepareData();
        InterestListAdapter interestListAdapter = new InterestListAdapter(requireActivity().getApplicationContext(), ArrayInterest);
        recyclerView.setAdapter(interestListAdapter);
        return tab;
    }
}
