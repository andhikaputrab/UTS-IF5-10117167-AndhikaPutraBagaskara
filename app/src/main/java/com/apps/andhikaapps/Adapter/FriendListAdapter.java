package com.apps.andhikaapps.Adapter;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    08 May 2020
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.apps.andhikaapps.Database.AppDatabase;
import com.apps.andhikaapps.Database.FriendListEntity;
import com.apps.andhikaapps.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    15 May 2020
 */

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.ViewHolder> {
    private ArrayList<FriendListEntity> listFriend;
    private Context context;

    public FriendListAdapter(Context context, ArrayList<FriendListEntity> listFriend){
        this.context = context;
        this.listFriend = listFriend;
        AppDatabase appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "AppDatabase").allowMainThreadQueries().build();
    }

    @NonNull
    @Override
    public FriendListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_list_friend, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendListAdapter.ViewHolder holder, int position) {
        holder.nama_teman.setText(listFriend.get(position).getNama_teman());
        Picasso.with(context).load(listFriend.get(position).getImage_teman()).into(holder.img_teman);
    }

    @Override
    public int getItemCount() {
        return listFriend.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama_teman;
        ImageView img_teman;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            nama_teman = itemView.findViewById(R.id.textViewList2);
            img_teman = itemView.findViewById(R.id.imageViewList2);
        }
    }
}
