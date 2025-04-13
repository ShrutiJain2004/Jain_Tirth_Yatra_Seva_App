package com.example.application;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.ViewHolder> {
    private Context context;
    private List<String> cities;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(String cityName);
    }

    public CityAdapter(Context context, List<String> cities, OnItemClickListener listener) {
        this.context = context;  // ✅ Fix: Assign context
        this.cities = cities;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String cityName = cities.get(position);  // ✅ Fix: Use String instead of Temple
        holder.txtCityName.setText(cityName);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, CityTempleActivity.class);
            intent.putExtra("selectedCity", cityName);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtCityName;

        public ViewHolder(View itemView) {
            super(itemView);
            txtCityName = itemView.findViewById(android.R.id.text1);  // ✅ Fix: Use correct ID for simple_list_item_1
        }
    }
}
