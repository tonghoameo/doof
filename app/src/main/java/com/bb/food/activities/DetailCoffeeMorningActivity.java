package com.bb.food.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.bb.food.R;
import com.bb.food.adapters.DetailCoffeeMorningAdapter;
import com.bb.food.models.DetailCoffeeMorningModel;

import java.util.ArrayList;
import java.util.List;

public class DetailCoffeeMorningActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ImageView imageView;
    List<DetailCoffeeMorningModel> detailCoffeeMorningModelList;
    DetailCoffeeMorningAdapter detailCoffeeMorningAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_coffee_morning);
        //get from intent activity
        String type = getIntent().getStringExtra("type");
        recyclerView = findViewById(R.id.detail_cfmorning_rec);
        imageView = findViewById(R.id.detailecfmorningimg);
        //Toast.makeText(this, "type :"+type, Toast.LENGTH_SHORT).show();
        detailCoffeeMorningModelList = new ArrayList<>();

        detailCoffeeMorningAdapter = new DetailCoffeeMorningAdapter(getBaseContext() ,detailCoffeeMorningModelList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(detailCoffeeMorningAdapter);

        if(type!=null && type.equalsIgnoreCase("coffee")){

            detailCoffeeMorningModelList.add(new DetailCoffeeMorningModel(R.drawable.logo,"latte","coffee latter","5","120","15:30-20:50"));
            detailCoffeeMorningModelList.add(new DetailCoffeeMorningModel(R.drawable.logo,"expresso","coffee latter","5","120","15:30-20:50"));
            detailCoffeeMorningModelList.add(new DetailCoffeeMorningModel(R.drawable.logo,"capuchino","coffee latter","5","120","15:30-20:50"));
            detailCoffeeMorningAdapter.notifyDataSetChanged();
        }
        if(type!=null && type.equalsIgnoreCase("beer")){
            imageView.setImageResource(R.drawable.bg);
            detailCoffeeMorningModelList.add(new DetailCoffeeMorningModel(R.drawable.logo,"tiger","coffee latter","5","120","15:30-20:50"));
            detailCoffeeMorningModelList.add(new DetailCoffeeMorningModel(R.drawable.logo,"saigon","coffee latter","5","120","15:30-20:50"));
            detailCoffeeMorningModelList.add(new DetailCoffeeMorningModel(R.drawable.logo,"heniken","coffee latter","5","120","15:30-20:50"));
            detailCoffeeMorningAdapter.notifyDataSetChanged();
        }
    }
}