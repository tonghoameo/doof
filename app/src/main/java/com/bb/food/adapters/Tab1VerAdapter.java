package com.bb.food.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.food.R;
import com.bb.food.models.Tab1Model;
import com.bb.food.models.Tab1VerModel;

import java.util.List;

public class Tab1VerAdapter extends RecyclerView.Adapter<Tab1VerAdapter.ViewHolder> {

    List<Tab1VerModel> tab1ModelList;

    public Tab1VerAdapter(List<Tab1VerModel> tab1ModelList) {
        this.tab1ModelList = tab1ModelList;
    }

    @NonNull
    @Override
    public Tab1VerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.tab1_ver_items,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Tab1VerAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(tab1ModelList.get(position).getImage());
        holder.name.setText(tab1ModelList.get(position).getName());
        holder.desc.setText(tab1ModelList.get(position).getDesc());
        holder.rating.setText(tab1ModelList.get(position).getRating());
        holder.desc.setText(tab1ModelList.get(position).getTiming());
    }

    @Override
    public int getItemCount() {
        return tab1ModelList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, desc, rating, timing;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.tab1_ver_item_img);
            name  = itemView.findViewById(R.id.tab1_ver_item_name);
            desc  = itemView.findViewById(R.id.tab1_ver_item_desc);
            rating  = itemView.findViewById(R.id.tab1_ver_item_rating);
            timing  = itemView.findViewById(R.id.tab1_ver_item_timing);
        }
    }
}
