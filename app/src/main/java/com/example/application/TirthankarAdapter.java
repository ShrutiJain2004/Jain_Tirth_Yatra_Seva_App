package com.example.application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TirthankarAdapter extends RecyclerView.Adapter<TirthankarAdapter.ViewHolder> {

    private final List<Tirthankar> tirthankarList;

    public TirthankarAdapter(List<Tirthankar> tirthankarList) {
        this.tirthankarList = tirthankarList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tirthankar, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tirthankar t = tirthankarList.get(position);
        holder.imageView.setImageResource(t.getImageResId());
        holder.nameView.setText(t.getName());
        holder.lanchanView.setText("Lanchan: " + t.getLanchan());
    }

    @Override
    public int getItemCount() {
        return tirthankarList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nameView, lanchanView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.tirthankarImage);
            nameView = itemView.findViewById(R.id.tirthankarName);
            lanchanView = itemView.findViewById(R.id.tirthankarLanchan);
        }
    }
}
