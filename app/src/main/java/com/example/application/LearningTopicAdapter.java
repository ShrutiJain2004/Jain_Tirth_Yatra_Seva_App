package com.example.application;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class LearningTopicAdapter extends RecyclerView.Adapter<LearningTopicAdapter.ViewHolder> {

    public interface OnTopicClickListener {
        void onTopicClick(LearningTopic topic);
    }

    private List<LearningTopic> topicList;
    private OnTopicClickListener listener;

    public LearningTopicAdapter(List<LearningTopic> topicList, OnTopicClickListener listener) {
        this.topicList = topicList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_learning_topic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LearningTopic topic = topicList.get(position);
        holder.title.setText(topic.getTitle());
        holder.image.setImageResource(topic.getImageResId());

        holder.itemView.setOnClickListener(v -> listener.onTopicClick(topic));
    }

    @Override
    public int getItemCount() {
        return topicList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.topicImage);
            title = itemView.findViewById(R.id.topicTitle);
        }
    }
}

