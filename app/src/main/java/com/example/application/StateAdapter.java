package com.example.application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.ViewHolder> {

    public interface OnStateClickListener {
        void onStateClick(String state);
    }

    private List<String> stateList;
    private OnStateClickListener listener;

    public StateAdapter(List<String> stateList, OnStateClickListener listener) {
        this.stateList = stateList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public StateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StateAdapter.ViewHolder holder, int position) {
        String state = stateList.get(position);
        holder.textView.setText(state);
        holder.itemView.setOnClickListener(v -> listener.onStateClick(state));
    }

    @Override
    public int getItemCount() {
        return stateList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}
