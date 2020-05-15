package com.apps.andhikaapps.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    07 May 2020
 */

@Dao
public interface AppDao {

    // Gallery Entity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addImage(GalleryEntity galleryEntity);

    @Query("SELECT * FROM table_gallery")
    GalleryEntity[] showImage();


    // Daily Entity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void AddImageDaily(DailyActivityEntity dailyActivityEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addDescDaily(DailyActivityEntity dailyActivityEntity);

    @Query("SELECT * FROM table_daily")
    DailyActivityEntity[] showDescDaily();

    @Query("SELECT * FROM table_daily")
    DailyActivityEntity[] showImageDaily();


    // Friend List Entity
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addImageTeman(FriendListEntity friendListEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addNamaTeman(FriendListEntity friendListEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addKota(FriendListEntity friendListEntity);

    @Query("SELECT * FROM table_friendlist")
    FriendListEntity[] showImageTeman();

    @Query("SELECT * FROM table_friendlist")
    FriendListEntity[] showNamaTeman();

    @Query("SELECT * FROM table_friendlist")
    FriendListEntity[] showKota();
}
