package com.bb.food.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bb.food.R;
import com.bb.food.adapters.Tab1HorAdapter;
import com.bb.food.adapters.Tab1VerAdapter;
import com.bb.food.models.Tab1Model;
import com.bb.food.models.Tab1VerModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FirstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {

    List<Tab1Model> tab1ModelList;
    List<Tab1VerModel> tab1VerModelList;
    RecyclerView tab1_hor_rec;
    RecyclerView tab1_ver_rec;
    Tab1HorAdapter tab1HorAdapter;
    Tab1VerAdapter tab1VerAdapter;


    public FirstFragment() {
        // Required empty public constructor
    }

    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view  = inflater.inflate(R.layout.fragment_first, container, false);
        tab1_hor_rec = view.findViewById(R.id.tab1_hor_rec);
        tab1_ver_rec = view.findViewById(R.id.tab1_ver_rec);

        tab1ModelList =  new ArrayList<>();
        tab1ModelList.add(new Tab1Model(R.drawable.logo, "coffee","pure cafe"));
        tab1ModelList.add(new Tab1Model(R.drawable.logo, "beer","heniken silver 5% achohol"));


        tab1VerModelList =  new ArrayList<>();
        tab1VerModelList.add(new Tab1VerModel(R.drawable.logo, "coffee","pure cafe","5","12:00-24:00"));
        tab1VerModelList.add(new Tab1VerModel(R.drawable.logo, "coffee","pure cafe","5","12:00-24:00"));
        tab1VerModelList.add(new Tab1VerModel(R.drawable.logo, "coffee","pure cafe","5","12:00-24:00"));
        tab1VerModelList.add(new Tab1VerModel(R.drawable.logo, "coffee","pure cafe","5","12:00-24:00"));
        tab1VerModelList.add(new Tab1VerModel(R.drawable.logo, "coffee","pure cafe","5","12:00-24:00"));
        tab1VerModelList.add(new Tab1VerModel(R.drawable.logo, "coffee","pure cafe","5","12:00-24:00"));

        tab1HorAdapter = new Tab1HorAdapter(tab1ModelList);
        tab1_hor_rec.setAdapter(tab1HorAdapter);
        tab1_hor_rec.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL, false));

        tab1VerAdapter = new Tab1VerAdapter(tab1VerModelList);
        tab1_ver_rec.setAdapter(tab1VerAdapter);
        tab1_ver_rec.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false));
        return view;
    }
}