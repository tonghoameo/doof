package com.bb.food.ui.coffeemorning;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.food.R;
import com.bb.food.adapters.CoffeeMorningAdapter;
import com.bb.food.models.CoffeeMorningModel;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMorningFragment extends Fragment {

    RecyclerView recyclerView;
    List<CoffeeMorningModel> coffeeMorningModelList;
    CoffeeMorningAdapter coffeeMorningAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {



        View root = inflater.inflate(R.layout.fragment_coffeemorning, container, false);
        recyclerView = root.findViewById(R.id.coffeemorning_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        coffeeMorningModelList = new ArrayList<>();

        coffeeMorningModelList.add(new CoffeeMorningModel(R.drawable.cfmorning,"capuchino","cafe capuchino","10%","coffee"));
        coffeeMorningModelList.add(new CoffeeMorningModel(R.drawable.cfmorning,"late","milk coffee","20%","coffee"));
        coffeeMorningModelList.add(new CoffeeMorningModel(R.drawable.cfmorning,"expresso","milk coffee","20%","coffee"));
        coffeeMorningModelList.add(new CoffeeMorningModel(R.drawable.cfmorning,"heniken","milk coffee","20%","beer"));

        coffeeMorningAdapter = new CoffeeMorningAdapter(getContext(),coffeeMorningModelList);
        recyclerView.setAdapter(coffeeMorningAdapter);
        Log.d("COFFEEMORNING", "setAdapter: coffeeMorningAdapter");
        coffeeMorningAdapter.notifyDataSetChanged();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}