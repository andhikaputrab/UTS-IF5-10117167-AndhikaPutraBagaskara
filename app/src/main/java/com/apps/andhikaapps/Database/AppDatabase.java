package com.apps.andhikaapps.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    07 May 2020
 */

@Database(entities = {GalleryEntity.class, DailyActivityEntity.class, FriendListEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AppDao appDao();
}