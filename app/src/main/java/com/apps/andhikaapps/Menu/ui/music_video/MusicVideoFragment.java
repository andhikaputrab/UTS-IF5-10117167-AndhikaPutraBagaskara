package com.apps.andhikaapps.Menu.ui.music_video;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.apps.andhikaapps.R;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    13 May 2020
 */

public class MusicVideoFragment extends Fragment {

    private ListView mySongListView;
    private String[] items;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View root = inflater.inflate(R.layout.fragment_menu_music_video, container, false);

        FragmentManager fragmentManager = getFragmentManager();

        //memulai transaction fragment manager
        assert fragmentManager != null;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        MusicListFragment musicListFragment = new MusicListFragment();
        //membuat object fragmentPertama
        transaction.add(R.id.frame_content, musicListFragment);
        //menambahkan fragment
        transaction.addToBackStack("fragmentPertama");
        //dapat menyimpan fragment ke dalam state ,ketika tombol back diklik
        transaction.commit();


        /*mySongListView = root.findViewById(R.id.SongListView);
        runtimePermission();*/
        return root;
    }

    /*@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
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

                    String songName = mySongListView.getItemAtPosition(i).toString();

                     startActivity(new Intent(requireActivity().getApplicationContext(), MusicPlayerFragment.class)
                     .putExtra("songs", mySongs).putExtra("songname",songName)
                     .putExtra("position",i));

                }
            });
        }

    }*/
}
