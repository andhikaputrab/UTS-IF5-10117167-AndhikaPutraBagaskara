package com.apps.andhikaapps.TabLayout.FriendList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.apps.andhikaapps.Adapter.FriendListAdapter;
import com.apps.andhikaapps.Database.AppDatabase;
import com.apps.andhikaapps.Database.FriendListEntity;
import com.apps.andhikaapps.R;

import java.util.ArrayList;
import java.util.Arrays;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    15 May 2020
 */

public class FriendListTabFragment extends Fragment {

    private ArrayList<FriendListEntity> friendListEntities = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View root = inflater.inflate(R.layout.fragment_tab_friend_list, container, false);

        AppDatabase appDatabase = Room.databaseBuilder(requireActivity().getApplicationContext(),
                AppDatabase.class, "AppDatabase").allowMainThreadQueries().build();

        FriendListData.prepareData(requireActivity().getApplicationContext());

        friendListEntities.addAll(Arrays.asList(appDatabase.appDao().showNamaTeman()));

        RecyclerView recyclerView = root.findViewById(R.id.recycler_view_friend);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new FriendListAdapter(requireActivity().getApplicationContext(), friendListEntities);
        recyclerView.setAdapter(adapter);

        return root;
    }
}
