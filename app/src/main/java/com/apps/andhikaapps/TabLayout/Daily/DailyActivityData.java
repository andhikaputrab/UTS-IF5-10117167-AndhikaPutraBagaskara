package com.apps.andhikaapps.TabLayout.Daily;

import android.content.Context;

import androidx.room.Room;

import com.apps.andhikaapps.Database.AppDatabase;
import com.apps.andhikaapps.Database.DailyActivityEntity;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    07 May 2020
 */

class DailyActivityData {

    private static final String[] desc_aktivitas = {
            "Olahraga",
            "Membaca Komik",
            "Menonton Film"
    };

    private static final String[] img_aktivitas = {
            "https://webstockreview.net/images/clipart-sports-individual-sport-3.png",
            "https://i.pinimg.com/564x/9c/48/0e/9c480eae054d6bc298a9ab00d485a8fc.jpg",
            "https://3.bp.blogspot.com/-P0qseM8Qzf0/UYJOtQsnyyI/AAAAAAAAAQk/IPquZKHUrQM/s1600/iron+man+3+poster.jpg"
    };

    static void prepareData(Context context){
        AppDatabase appDatabase = Room.databaseBuilder(context,
                AppDatabase.class, "AppDatabase").allowMainThreadQueries().build();

        DailyActivityEntity dailyActivityEntity = new DailyActivityEntity();
        for (int i=0; i<desc_aktivitas.length; i++){
            dailyActivityEntity.setDesc_daily(desc_aktivitas[i]);
            appDatabase.appDao().addDescDaily(dailyActivityEntity);
            dailyActivityEntity.setImage_daily(img_aktivitas[i]);
            appDatabase.appDao().AddImageDaily(dailyActivityEntity);
        }
    }
}
