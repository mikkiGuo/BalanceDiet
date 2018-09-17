package com.example.mikki.balancediet.dietpicker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mikki.balancediet.R;

import java.util.ArrayList;
import java.util.List;


public class RVDietPickerAdapter extends RecyclerView.Adapter<RVDietPickerAdapter.MyViewHolder>{

    List<Food> foodList;

    //holding the item and the view.
    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;

        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_foodname);

        }
    }

    @NonNull
    @Override
    //where we going to create the view holder, and set layout, etc
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.dp_item_layout,
                parent,false);

        return new MyViewHolder(rootView);
    }

    public RVDietPickerAdapter(ArrayList<Food> foods) {
        foodList = foods;
    }

    @Override
    //bind data with the holder
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.name.setText(food.name);

        
    }

    @Override
    //get the size of the list
    public int getItemCount() {
        return foodList.size();
    }





}
