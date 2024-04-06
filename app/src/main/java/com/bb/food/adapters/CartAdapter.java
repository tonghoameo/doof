package com.bb.food.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.food.R;
import com.bb.food.models.CartModel;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {


    List<CartModel> cartModelList;

    public CartAdapter(List<CartModel> cartModelList) {
        this.cartModelList = cartModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mycart_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(cartModelList.get(position).getImageView());
        holder.name.setText(cartModelList.get(position).getName());
        holder.rating.setText(cartModelList.get(position).getRating());
        holder.price.setText(cartModelList.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return cartModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, rating, price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.mycart_item_img);
            name = itemView.findViewById(R.id.mycart_item_name);
            rating = itemView.findViewById(R.id.mycart_item_rating);
            price = itemView.findViewById(R.id.mycart_item_price);
        }
    }
}
