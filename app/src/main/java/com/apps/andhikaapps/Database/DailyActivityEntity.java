package com.apps.andhikaapps.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    07 May 2020
 */

@Entity(tableName = "table_daily")
public class DailyActivityEntity {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "desc_daily")
    private String desc_daily;

    @ColumnInfo(name = "img_daily")
    private String image_daily;

    @NotNull
    public String getDesc_daily() {
        return desc_daily;
    }

    public void setDesc_daily(@NotNull String desc_daily){
        this.desc_daily = desc_daily;
    }

    public String getImage_daily() {
        return image_daily;
    }

    public void setImage_daily(String image_daily){
        this.image_daily = image_daily;
    }
}
