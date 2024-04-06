package com.bb.food.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.food.R;
import com.bb.food.models.HomeHorModel;
import com.bb.food.models.HomeVerModel;

import java.util.ArrayList;
import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {
    Activity activity;

    UpdateVerRec updateVerRec;
    boolean check = true;
    boolean select = true;
    int row_idx = -1;
    // horizontal is categories, vertical is product of cate
//    Context context;
    List<HomeHorModel> homeHorModelList;

    public HomeHorAdapter(Activity activity, UpdateVerRec updateVerRec, List<HomeHorModel> homeHorModelList) {
        this.activity = activity;
        this.updateVerRec = updateVerRec;
        this.homeHorModelList = homeHorModelList;
    }

    @Override
    public HomeHorAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_items, parent,false));
    }

    @Override
    public void onBindViewHolder(HomeHorAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.imageView.setImageResource(homeHorModelList.get(position).getImage());
        holder.textView.setText(homeHorModelList.get(position).getName());



        if (check) {
            ArrayList<HomeVerModel> homeVerModelList = new ArrayList<>();
            homeVerModelList.add(new HomeVerModel(R.drawable.logo, "latter", "10:15-15:00", "4.5", "10"));
            homeVerModelList.add(new HomeVerModel(R.drawable.logo, "capuchino", "10:15-15:00", "4.5", "10"));
            homeVerModelList.add(new HomeVerModel(R.drawable.logo, "expresso", "10:15-15:00", "4.5", "10"));
            homeVerModelList.add(new HomeVerModel(R.drawable.logo, "salt coffee", "10:15-15:00", "4.5", "10"));
            homeVerModelList.add(new HomeVerModel(R.drawable.logo, "pure coffee", "10:15-15:00", "4.5", "10"));
            updateVerRec.callBack(position, homeVerModelList);
        }
            check =false;

            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("CLICK", "onClick: clicked");
                    row_idx = position;
                    notifyDataSetChanged();

                    if(row_idx == 0){
                        ArrayList<HomeVerModel> homeVerModelList = new ArrayList<>();
                        homeVerModelList.add(new HomeVerModel(R.drawable.logo,"heniken","10:15-15:00","4.5","10"));
                        homeVerModelList.add(new HomeVerModel(R.drawable.logo,"tiger","10:15-15:00","4.5","10"));
                        homeVerModelList.add(new HomeVerModel(R.drawable.logo,"saigon","10:15-15:00","4.5","10"));
                        homeVerModelList.add(new HomeVerModel(R.drawable.logo,"333 beer","10:15-15:00","4.5","10"));
                        homeVerModelList.add(new HomeVerModel(R.drawable.logo,"Thang long","10:15-15:00","4.5","10"));
                        updateVerRec.callBack(position, homeVerModelList);
                        Log.d("ROW IDX", " "+ String.valueOf(row_idx));
                    }else if(position == 1) {
                        ArrayList<HomeVerModel> homeVerModelList = new ArrayList<>();
                        homeVerModelList.add(new HomeVerModel(R.drawable.logo,"wickey","10:15-15:00","4.5","10"));
                        homeVerModelList.add(new HomeVerModel(R.drawable.logo,"vodka","10:15-15:00","4.5","10"));
                        homeVerModelList.add(new HomeVerModel(R.drawable.logo,"rum","10:15-15:00","4.5","10"));
                        homeVerModelList.add(new HomeVerModel(R.drawable.logo,"vang","10:15-15:00","4.5","10"));
                        homeVerModelList.add(new HomeVerModel(R.drawable.logo,"rice ","10:15-15:00","4.5","10"));
                        updateVerRec.callBack(position, homeVerModelList);
                        Log.d("ROW IDX", " "+ String.valueOf(row_idx));
                    }
                }
            });


            if(select){
                if(position == 0){
                    holder.cardView.setBackgroundResource(R.drawable.select_bg);
                    select = false;

                }

            }else {
                if(position == row_idx){
                    // search and default same each other
                    holder.cardView.setBackgroundResource(R.drawable.select_bg);
                }else{
                    holder.cardView.setBackgroundResource(R.drawable.search_bg);
                }
            }
    }

    @Override
    public int getItemCount() {
        return this.homeHorModelList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        // carousel
        ImageView imageView;
        TextView textView;
        CardView cardView;
        public ViewHolder( View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hor_img);
            textView = itemView.findViewById(R.id.hor_txt);
            // we update effect cardview is selected
            cardView = itemView.findViewById(R.id.horcardview);

        }
    }
}
