package com.apps.andhikaapps.TabLayout.Daily;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.apps.andhikaapps.Adapter.DailyListAdapter;
import com.apps.andhikaapps.Database.AppDatabase;
import com.apps.andhikaapps.Database.DailyActivityEntity;
import com.apps.andhikaapps.R;

import java.util.ArrayList;
import java.util.Arrays;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    07 may 2020
 */

public class DailyTabFragment extends Fragment {

    private ArrayList<DailyActivityEntity> dailyActivityEntities = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_tab_daily_list, container, false);

        AppDatabase appDatabase = Room.databaseBuilder(requireActivity().getApplicationContext(),
                AppDatabase.class, "AppDatabase").allowMainThreadQueries().build();

        DailyActivityData.prepareData(requireActivity().getApplicationContext());

        dailyActivityEntities.addAll(Arrays.asList(appDatabase.appDao().showDescDaily()));

        RecyclerView recyclerView = root.findViewById(R.id.recycler_view_daily);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new DailyListAdapter(requireActivity().getApplicationContext(), dailyActivityEntities);
        recyclerView.setAdapter(adapter);
        return root;
    }
}
