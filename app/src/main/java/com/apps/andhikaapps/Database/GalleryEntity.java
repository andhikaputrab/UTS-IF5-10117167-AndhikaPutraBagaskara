package com.apps.andhikaapps.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    11 May 2020
 */

@Entity(tableName = "table_gallery")
public class GalleryEntity {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "image_gallery")
    private String image_gallery;

    @NotNull
    public String getImage_gallery(){
        return image_gallery;
    }

    public void setImage_gallery(@NotNull String image_gallery) {
        this.image_gallery = image_gallery;
    }
}
