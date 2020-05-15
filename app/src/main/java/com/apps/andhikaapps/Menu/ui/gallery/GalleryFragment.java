package com.apps.andhikaapps.Menu.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.apps.andhikaapps.Adapter.GalleryGridAdapter;
import com.apps.andhikaapps.Database.AppDatabase;
import com.apps.andhikaapps.Database.GalleryEntity;
import com.apps.andhikaapps.R;

import java.util.ArrayList;
import java.util.Arrays;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    11 May 2020
 */

public class GalleryFragment extends Fragment {

    private ArrayList<GalleryEntity> galleryEntities = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_menu_gallery, container, false);

        AppDatabase appDatabase = Room.databaseBuilder(requireActivity().getApplicationContext(),
                AppDatabase.class, "AppDatabase").allowMainThreadQueries().build();

        GalleryData.prepareData(requireActivity().getApplicationContext());

        galleryEntities.addAll(Arrays.asList(appDatabase.appDao().showImage()));

        RecyclerView recyclerView = root.findViewById(R.id.recycler_view_gallery);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(requireActivity().getApplicationContext(), 2);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new GalleryGridAdapter(requireActivity().getApplicationContext(),galleryEntities);
        recyclerView.setAdapter(adapter);
        return root;
    }
}
