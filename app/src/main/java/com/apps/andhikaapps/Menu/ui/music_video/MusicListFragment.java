package com.apps.andhikaapps.Menu.ui.music_video;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.apps.andhikaapps.R;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    13 May 2020
 */

public class MusicListFragment extends Fragment {

    private Toolbar toolbar;
    private ListView mySongListView;
    private String[] items;
    private static String SONGS = "songs";
    private static String SONGNAME = "songname";
    private static String POS = "pos";


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_music_list, container, false);

        mySongListView = root.findViewById(R.id.SongListView);
        //toolbar = root.findViewById(R.id.toolbarmusiclist);

        /*toolbar.setTitle("PlayList");
        requireActivity().setActionBar(toolbar);*/

        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        runtimePermission();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void runtimePermission(){

        Dexter.withActivity(getActivity())
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        display();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    private ArrayList<File> findSong(File file){

        ArrayList<File> arrayList = new ArrayList<>();

        File[] files = file.listFiles();

        assert files != null;
        for (File singleFile : files){
            if (singleFile.isDirectory() && !singleFile.isHidden()){

                arrayList.addAll(findSong(singleFile));
            } else {
                if (singleFile.getName().endsWith(".mp3") ||
                        singleFile.getName().endsWith(".wav")) {

                    arrayList.add(singleFile);
                }
            }
        }
        return  arrayList;
    }

    private void display(){
        final ArrayList<File> mySongs = findSong(Environment.getExternalStorageDirectory());

        items = new String[mySongs.size()];

        for (int i=0; i<mySongs.size(); i++){

            items[i] = mySongs.get(i).getName().replace(".mp3", "").replace(".wav", "");

            ArrayAdapter<String> myAdapter = new ArrayAdapter<>(requireActivity(), android.R.layout.simple_list_item_1, items);
            mySongListView.setAdapter(myAdapter);

            mySongListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                    MusicPlayerFragment musicPlayerFragment = new MusicPlayerFragment();
                    String songName = mySongListView.getItemAtPosition(i).toString();

                    Bundle bundle = new Bundle();
                    bundle.putSerializable(SONGS, mySongs);
                    bundle.putString(SONGNAME, songName);
                    bundle.putInt(POS, i);
                    musicPlayerFragment.setArguments(bundle);

                    FragmentManager fragmentManager = getFragmentManager();
                    assert fragmentManager != null;
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frame_content, musicPlayerFragment, MusicPlayerFragment.class.getSimpleName());
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();

                    /*assert getFragmentManager() != null;
                    getFragmentManager().beginTransaction().replace(R.id.frame_content, musicPlayerFragment)
                            .addToBackStack(null).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();*/

                    /*startActivity(new Intent(requireActivity().getApplicationContext(), MusicPlayerFragment.class)
                            .putExtra("songs", mySongs).putExtra("songname",songName)
                            .putExtra("position",i));*/

                }
            });
        }

    }
}
