package com.bb.food.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
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
import com.bb.food.models.CoffeeMorningModel;

import java.util.List;

public class CoffeeMorningAdapter extends RecyclerView.Adapter<CoffeeMorningAdapter.ViewHolder> {

    Context context;
    List<CoffeeMorningModel> coffeeMorningModelList;

    public CoffeeMorningAdapter(Context context, List<CoffeeMorningModel> coffeeMorningModelList) {
        Log.d("COFFEEMORNING", "CoffeeMorningAdapter: create on cuss");
        this.context = context;
        this.coffeeMorningModelList = coffeeMorningModelList;
    }
    @NonNull
    @Override
    public CoffeeMorningAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
         Log.d("COFFEEMORNING", "onCreateViewHolder: create on cuss");
         return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.coffee_morning_items,parent,false));
    }

    @Override
    public void onBindViewHolder(CoffeeMorningAdapter.ViewHolder holder,  int position) {
        holder.imageView.setImageResource(coffeeMorningModelList.get(position).getImage());
        holder.name.setText(coffeeMorningModelList.get(position).getName());
        holder.desc.setText(coffeeMorningModelList.get(position).getDesc());
        holder.discount.setText(coffeeMorningModelList.get(position).getDiscount());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "itemView is clicked at "+coffeeMorningModelList.get(holder.getAdapterPosition()).getType(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, DetailCoffeeMorningActivity.class);
                intent.putExtra("type", coffeeMorningModelList.get(holder.getAdapterPosition()).getType());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return coffeeMorningModelList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView ;
        TextView name, discount, desc;
        public ViewHolder( View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgviewfromcfmorning);
            name = itemView.findViewById(R.id.namefromcfmorning);
            desc = itemView.findViewById(R.id.descfromcfmorning);
            discount = itemView.findViewById(R.id.notefromcfmorning);
            Log.d("COFFEEMORNING", "ViewHolder: create on cuss");

        }
    }
}
