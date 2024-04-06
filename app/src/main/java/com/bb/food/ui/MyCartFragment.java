package com.bb.food.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bb.food.R;
import com.bb.food.adapters.CartAdapter;
import com.bb.food.models.CartModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyCartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyCartFragment extends Fragment {

    List<CartModel> cartModelList;
    CartAdapter cartAdapter;
    RecyclerView recyclerView;
    public MyCartFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static MyCartFragment newInstance(String param1, String param2) {
        MyCartFragment fragment = new MyCartFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_my_cart, container, false);
        recyclerView = view.findViewById(R.id.mycartrec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        cartModelList = new ArrayList<>();

        cartModelList.add(new CartModel(R.drawable.cfmorning,"coffee","4","10000VND"));
        cartModelList.add(new CartModel(R.drawable.cfmorning,"beer","4","4500000VND"));

        cartAdapter = new CartAdapter(cartModelList);
        recyclerView.setAdapter(cartAdapter);
        return view;
    }
}