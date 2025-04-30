package com.example.application;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TempleAdapter extends RecyclerView.Adapter<TempleAdapter.ViewHolder> {

    private final Context context;
    private final List<Temple> templeList;

    public TempleAdapter(Context context, List<Temple> templeList) {
        this.context = context;
        this.templeList = templeList;
    }

    @NonNull
    @Override
    public TempleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_temple, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TempleAdapter.ViewHolder holder, int position) {
        Temple temple = templeList.get(position);

        // Set data
        holder.templeName.setText(temple.getName());
        holder.templeImage.setImageResource(temple.getImageResId());

        // Click on temple image+name to open TempleDetailActivity
        holder.templeContainer.setOnClickListener(v -> {
            Intent intent = new Intent(context, TempleDetailActivity.class);
            intent.putExtra("temple_name", temple.getName());
            intent.putExtra("temple_history", temple.getHistory());
            intent.putExtra("temple_image", temple.getImageResId());
            intent.putExtra("temple_address", temple.getAddress());
            intent.putExtra("temple_contact", temple.getContact());
            intent.putExtra("temple_map_url", temple.getMapUrl());
            context.startActivity(intent);
        });

        // Click on Dharamshala text to open DharamshalaActivity
        holder.dharamshalaOption.setOnClickListener(v -> {
            Intent intent = new Intent(context, DharamshalaActivity.class);
            intent.putExtra("tirth_name", temple.getName());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return templeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView templeImage;
        TextView templeName, dharamshalaOption;
        View templeContainer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            templeImage = itemView.findViewById(R.id.imgTemple);
            templeName = itemView.findViewById(R.id.templeName);
            dharamshalaOption = itemView.findViewById(R.id.dharamshalaOption);
            templeContainer = itemView.findViewById(R.id.templeContainer);
        }
    }
}
