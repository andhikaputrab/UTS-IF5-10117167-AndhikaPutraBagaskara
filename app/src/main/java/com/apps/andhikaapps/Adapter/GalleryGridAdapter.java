package com.apps.andhikaapps.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.apps.andhikaapps.Database.AppDatabase;
import com.apps.andhikaapps.Database.GalleryEntity;
import com.apps.andhikaapps.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    11 May 2020
 */

public class GalleryGridAdapter extends RecyclerView.Adapter<GalleryGridAdapter.ViewHolder> {
    private ArrayList<GalleryEntity> listGallery;
    private Context context;

    public GalleryGridAdapter(Context context, ArrayList<GalleryEntity> listGallery){
        this.context = context;
        this.listGallery = listGallery;
        AppDatabase appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "AppDatabase").allowMainThreadQueries().build();
    }

    @NonNull
    @Override
    public GalleryGridAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_grid_gallery, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.nama_image.setText(listGallery.get(position).getNama_image());
        Picasso.with(context).load(listGallery.get(position).getImage_gallery()).resize(250, 290).into(holder.image_gallery);
    }

    @Override
    public int getItemCount() {
        return listGallery.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView image_gallery;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_gallery = itemView.findViewById(R.id.img_gallery);

        }
    }
}
