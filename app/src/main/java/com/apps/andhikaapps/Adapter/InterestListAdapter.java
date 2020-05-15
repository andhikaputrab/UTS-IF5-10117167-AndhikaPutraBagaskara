package com.apps.andhikaapps.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apps.andhikaapps.Model.ModelInterest;
import com.apps.andhikaapps.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/*
    Developed by Andhika Putra Bagaskara - 10117167 - IF5
    06 May 2020
 */

public class InterestListAdapter extends RecyclerView.Adapter<InterestListAdapter.ViewHolder> {
    private ArrayList<ModelInterest> listModelInterests;
    private Context context;

    public InterestListAdapter(Context context, ArrayList<ModelInterest> listModelInterests){
        this.context = context;
        this.listModelInterests = listModelInterests;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_grid_interest, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InterestListAdapter.ViewHolder holder, int position) {
        holder.txt_interest.setText(listModelInterests.get(position).getNama_hobby());
        Picasso.with(context).load(listModelInterests.get(position).getImage_hobby()).resize(100, 100).into(holder.img_interest);
    }

    @Override
    public int getItemCount() {
        return listModelInterests.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_interest;
        private TextView txt_interest;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_interest = itemView.findViewById(R.id.textView_interest);
            img_interest = itemView.findViewById(R.id.img_interest);
        }
    }
}
