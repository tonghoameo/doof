package com.bb.food.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.food.R;
import com.bb.food.activities.DetailCoffeeMorningActivity;
import com.bb.food.models.DetailCoffeeMorningModel;

import java.util.List;

public class DetailCoffeeMorningAdapter  extends RecyclerView.Adapter<DetailCoffeeMorningAdapter.ViewHolder> {

    Context context;
    List<DetailCoffeeMorningModel> detailCoffeeMorningModelList;
    public DetailCoffeeMorningAdapter(Context ctx,List<DetailCoffeeMorningModel> detailCoffeeMorningModelList){
        this.detailCoffeeMorningModelList = detailCoffeeMorningModelList;
        this.context = ctx;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_coffee_morning_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(detailCoffeeMorningModelList.get(position).getImage());
       // holder.image.setImageResource(R.drawable.bg);

        holder.name.setText(detailCoffeeMorningModelList.get(position).getName());
        holder.rating.setText(detailCoffeeMorningModelList.get(position).getRating());
        holder.desc.setText(detailCoffeeMorningModelList.get(position).getDesc());
        holder.timing.setText(detailCoffeeMorningModelList.get(position).getTiming());
        holder.price.setText(detailCoffeeMorningModelList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return detailCoffeeMorningModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, desc, rating, price, timing;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image  = itemView.findViewById(R.id.detailed_item_img);
            name   =  itemView.findViewById(R.id.detailed_item_name);
            desc   =  itemView.findViewById(R.id.detailed_item_desc);
            rating =  itemView.findViewById(R.id.detailed_item_rating);
            timing =  itemView.findViewById(R.id.detailed_item_timing);
            price =  itemView.findViewById(R.id.detailed_item_price);
        }
    }
}
