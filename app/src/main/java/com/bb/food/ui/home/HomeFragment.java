package com.bb.food.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bb.food.R;
import com.bb.food.adapters.HomeHorAdapter;
import com.bb.food.adapters.HomeVerAdapter;
import com.bb.food.adapters.UpdateVerRec;
import com.bb.food.models.CoffeeMorningModel;
import com.bb.food.models.HomeHorModel;
import com.bb.food.models.HomeVerModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements UpdateVerRec {

    RecyclerView homehorrec, homeverrec;
    HomeHorAdapter homeHorAdapter;
    HomeVerAdapter homeVerAdapter;
    ArrayList<HomeHorModel> homeHorModellist;
    ArrayList<HomeVerModel> homeVerModelList;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homehorrec = root.findViewById(R.id.home_hor_recycleV);
        homeverrec = root.findViewById(R.id.home_ver_recycleV);

        homeHorModellist =  new ArrayList<HomeHorModel>();
        homeHorModellist.add(new HomeHorModel(R.drawable.logo,"coffee"));
        homeHorModellist.add(new HomeHorModel(R.drawable.logo,"beer"));
        homeHorModellist.add(new HomeHorModel(R.drawable.logo,"wine"));
        homeHorModellist.add(new HomeHorModel(R.drawable.logo,"soda"));
        homeHorModellist.add(new HomeHorModel(R.drawable.logo,"water"));

        homeVerModelList = new ArrayList<HomeVerModel>();
        homeVerModelList.add(new HomeVerModel(R.drawable.logo,"latter","10:15-15:00","4.5","10"));
        homeVerModelList.add(new HomeVerModel(R.drawable.logo,"capuchino","10:15-15:00","4.5","10"));
        homeVerModelList.add(new HomeVerModel(R.drawable.logo,"expresso","10:15-15:00","4.5","10"));
        homeVerModelList.add(new HomeVerModel(R.drawable.logo,"expresso","10:15-15:00","4.5","10"));
        homeVerModelList.add(new HomeVerModel(R.drawable.logo,"expresso","10:15-15:00","4.5","10"));

        homeHorAdapter =  new HomeHorAdapter(  getActivity(), this,homeHorModellist);
        homehorrec.setAdapter(homeHorAdapter);
        homehorrec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homehorrec.setHasFixedSize(true);
        homehorrec.setNestedScrollingEnabled(false);

        homeVerAdapter =  new HomeVerAdapter(getContext(), homeVerModelList);
        homeverrec.setAdapter(homeVerAdapter);
        homeverrec.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        homeverrec.setHasFixedSize(true);
        homeverrec.setNestedScrollingEnabled(false);
        ImageView searchbtn = root.findViewById(R.id.home_seach_coffee);
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search1();
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void callBack(int pos, ArrayList<HomeVerModel> list) {
        // update veradapter
        homeVerAdapter = new HomeVerAdapter(getContext(),list);
        homeVerAdapter.notifyDataSetChanged();
        homeverrec.setAdapter(homeVerAdapter);
        Log.d("UPDATE", "update veradapter: " + list.toString());
    }


    private void search1(){

        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        firestore.collection("coffees_search").whereEqualTo("type","beer").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

                if(task.isSuccessful() && task.getResult()!=null){
                    homeVerModelList.clear();

                    for(DocumentSnapshot ds: task.getResult().getDocuments()){

                        CoffeeMorningModel cf = ds.toObject(CoffeeMorningModel.class);
                        Log.d("SEARCH", "onComplete: " + cf.toString());
                        homeVerModelList.add(new HomeVerModel(R.drawable.cart,cf.getName(),"10:00","4","10"));

                    }

                    Toast.makeText(getContext(), "find out "+String.valueOf(homeVerModelList.size()), Toast.LENGTH_SHORT).show();
                    homeVerAdapter = new HomeVerAdapter(getContext(), homeVerModelList);
                    homeverrec.setAdapter(homeVerAdapter);

                }

            }
        });
    }


}