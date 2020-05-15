package com.apps.andhikaapps.Database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    15 May 2020
 */

@Entity(tableName = "table_friendlist")
public class FriendListEntity {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "nama_teman")
    private String nama_teman;
    @ColumnInfo(name = "image_teman")
    private int image_teman;
    @ColumnInfo(name = "kota")
    private String kota;

    @NotNull
    public String getNama_teman(){
        return nama_teman;
    }

    public void setNama_teman(@NotNull String nama_teman){
        this.nama_teman = nama_teman;
    }

    public int getImage_teman(){
        return image_teman;
    }

    public void setImage_teman(int image_teman){
        this.image_teman = image_teman;
    }

    String getKota(){
        return kota;
    }

    void setKota(String kota){
        this.kota = kota;
    }

}
