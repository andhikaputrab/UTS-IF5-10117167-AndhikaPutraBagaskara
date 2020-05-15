package com.apps.andhikaapps.TabLayout.FriendList;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    08 May 2020
 */

import android.content.Context;

import androidx.room.Room;

import com.apps.andhikaapps.Database.AppDatabase;
import com.apps.andhikaapps.Database.FriendListEntity;
import com.apps.andhikaapps.R;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    15 May 2020
 */

class FriendListData {

    private static final String[] desc_nama = {
            "Ian Herdiansyah",
            "Achmad Raynaldo",
    };

    private static final int[] img_teman = {
            R.drawable.pict_ian,
            R.drawable.pict_aldo
    };

    static void prepareData(Context context){
        AppDatabase appDatabase = Room.databaseBuilder(context,
                AppDatabase.class, "AppDatabase").allowMainThreadQueries().build();

        FriendListEntity friendListEntity = new FriendListEntity();
        for (int i=0; i<desc_nama.length; i++){
            friendListEntity.setNama_teman(desc_nama[i]);
            appDatabase.appDao().addNamaTeman(friendListEntity);
            friendListEntity.setImage_teman(img_teman[i]);
            appDatabase.appDao().addImageTeman(friendListEntity);
        }
    }

}
