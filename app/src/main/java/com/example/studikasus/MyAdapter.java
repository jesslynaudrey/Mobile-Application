package com.example.studikasus;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {

    Context context;
    ArrayList<HistoryModel> historyModels;

    public MyAdapter(Context context, ArrayList<HistoryModel> historyModels) {
        this.context = context;
        this.historyModels = historyModels;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, parent, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.icon.setImageResource(historyModels.get(position).getIcon());
        holder.name.setText(historyModels.get(position).getName());
        holder.date.setText(historyModels.get(position).getDate());
        holder.price.setText(historyModels.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return historyModels.size();
    }

    public static class Holder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView name, date, price;

        public Holder(@NonNull View itemView) {
            super(itemView);

            icon = itemView.findViewById(R.id.icon);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            price = itemView.findViewById(R.id.price);
        }
    }
}
