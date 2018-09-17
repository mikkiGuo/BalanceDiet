package com.example.mikki.balancediet.dietpicker;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
//import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mikki.balancediet.R;

import java.util.ArrayList;


public class DietPicker extends Fragment implements IDietPicker {

    RecyclerView recyclerView;
    RVDietPickerAdapter adapter;
    ArrayList<Food> foods = new ArrayList<Food>();



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diet_picker, container,false);

        recyclerView = view.findViewById(R.id.rv_dietpicker);
        adapter = new RVDietPickerAdapter(foods);

        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        setFoodData();

        return view;
    }

    private void setFoodData() {
        Food foodItem1 = new Food("Spinach", "Vegetable");
        Food foodItem2 = new Food("Beef", "Protein");
        Food foodItem3 = new Food("Rice", "Carbohydrate");
        foods.add(foodItem1);
        foods.add(foodItem2);
        foods.add(foodItem3);
        adapter.notifyDataSetChanged(); // refresh recycler when there is changes in data.


    }


}
