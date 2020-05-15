package com.apps.andhikaapps.Menu.ui.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import androidx.room.Room;

import com.apps.andhikaapps.Database.AppDatabase;
import com.apps.andhikaapps.Database.GalleryEntity;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    11 May 2020
 */

public class GalleryData{
    private Context mContext;

    public GalleryData(Context context){
        mContext = context;
    }

    private static final String[] image_gallery = {
            "https://i.pinimg.com/564x/48/ba/41/48ba41d61f3c45d00fd7517db42185d3.jpg",
            "https://i.pinimg.com/564x/78/15/1d/78151d381d31f60d3cda23df8b3130fc.jpg",
            "https://i.pinimg.com/564x/8c/ec/52/8cec52692dfcefdaf3b6a1220b6dbb35.jpg",
            "https://i.pinimg.com/564x/a2/91/01/a291014d1f9035e924a7564577abf905.jpg",
            "https://i.pinimg.com/564x/a4/97/84/a49784816c147e919a676695cddb7909.jpg",
            "https://i.pinimg.com/564x/c3/31/20/c33120d12fee573f0447283b9ff29088.jpg",
            "https://i.pinimg.com/564x/e4/1b/7c/e41b7cb0a22877d762da2a4859e39543.jpg",
            "https://i.pinimg.com/564x/65/ae/4e/65ae4e978f98be30c836ccca0ea2fee2.jpg",
            "https://i.pinimg.com/564x/e0/cc/29/e0cc29b575ea0eb8b805ddff2f148829.jpg",
            "https://i.pinimg.com/564x/38/5d/e3/385de385d8a98d5c4d12b097b9ed8cc8.jpg",
            "https://i.pinimg.com/564x/6d/81/93/6d81934cb05853b33cd51f83606a4012.jpg"
    };

    static void prepareData(Context context){
        AppDatabase appDatabase = Room.databaseBuilder(context,
                AppDatabase.class, "AppDatabase").allowMainThreadQueries().build();

        GalleryEntity galleryEntity = new GalleryEntity();
        for (String s : image_gallery) {
            galleryEntity.setImage_gallery(s);
            appDatabase.appDao().addImage(galleryEntity);
        }
    }
}
