package com.apps.andhikaapps.Adapter;

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
import com.apps.andhikaapps.Database.DailyActivityEntity;
import com.apps.andhikaapps.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    07 May 2020
 */

public class DailyListAdapter extends RecyclerView.Adapter<DailyListAdapter.ViewHolder> {
    private ArrayList<DailyActivityEntity> listDaily;
    private Context context;

    public DailyListAdapter(Context context, ArrayList<DailyActivityEntity> listDaily){
        this.context = context;
        this.listDaily = listDaily;
        AppDatabase appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "AppDatabase").allowMainThreadQueries().build();
    }

    @NonNull
    @Override
    public DailyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_list_daily, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DailyListAdapter.ViewHolder holder, int position) {
        holder.textView_daily.setText(listDaily.get(position).getDesc_daily());
        Picasso.with(context).load(listDaily.get(position).getImage_daily()).into(holder.image_daily);
    }

    @Override
    public int getItemCount() {
        return listDaily.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView_daily;
        private ImageView image_daily;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_daily = itemView.findViewById(R.id.textViewList);
            image_daily = itemView.findViewById(R.id.imageViewList);
        }
    }
}
