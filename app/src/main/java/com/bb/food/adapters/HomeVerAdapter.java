package com.bb.food.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.food.R;
import com.bb.food.models.HomeVerModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;
import java.util.zip.Inflater;

public class HomeVerAdapter extends RecyclerView .Adapter<HomeVerAdapter.ViewHolder>{
    BottomSheetDialog bottomSheetDialog;
    Context context;
    List<HomeVerModel> homeVerModelList;

    public HomeVerAdapter(Context ctx, List<HomeVerModel> homeVerModelList){
        this.context = ctx;
        this.homeVerModelList = homeVerModelList;
    }
    @Override
    public HomeVerAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_ver_items,parent, false));
    }

    @Override
    public void onBindViewHolder( HomeVerAdapter.ViewHolder holder, int position) {
        final int mImage =homeVerModelList.get(position).getImage();
        final String mTiming =homeVerModelList.get(position).getTiming();
        final String mRating =homeVerModelList.get(position).getRating();
        final String mPrice =homeVerModelList.get(position).getPrice();
        final String mName =homeVerModelList.get(position).getName();

        holder.imageView.setImageResource(homeVerModelList.get(position).getImage());
        holder.name.setText(homeVerModelList.get(position).getName());
        holder.rating.setText(homeVerModelList.get(position).getRating());
        holder.timing.setText(homeVerModelList.get(position).getTiming());
        holder.price.setText(homeVerModelList.get(position).getPrice());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog = new BottomSheetDialog(context, R.style.BottomSheetTheme);
                View sheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet,null);
                sheetView.findViewById(R.id.bottom_sheet_item_addBtn).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, "Added to a cart", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });
                ImageView bottomImg = sheetView.findViewById(R.id.bottom_sheet_img);
                TextView bottomName = sheetView.findViewById(R.id.bottom_sheet_item_name);
                TextView bottomRating = sheetView.findViewById(R.id.bottom_sheet_item_rating);
                TextView bottomPrice = sheetView.findViewById(R.id.bottom_sheet_item_price);
                TextView bottomTiming = sheetView.findViewById(R.id.bottom_sheet_item_timing);
                bottomName.setText(mName);
                bottomRating.setText(mRating);
                bottomPrice.setText(mRating);
                bottomTiming.setText(mTiming);
                bottomImg.setImageResource(mImage);

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return homeVerModelList.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, price,timing,rating;
        public ViewHolder( View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ver_img);
            name = itemView.findViewById(R.id.ver_name);
            timing = itemView.findViewById(R.id.timing);
            rating = itemView.findViewById(R.id.rating);
            price = itemView.findViewById(R.id.ver_price);

        }
    }
}
