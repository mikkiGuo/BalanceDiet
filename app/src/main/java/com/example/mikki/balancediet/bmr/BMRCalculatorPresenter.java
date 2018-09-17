package com.example.mikki.balancediet.bmr;

import android.view.View;

import com.example.mikki.balancediet.R;

import java.util.ArrayList;

public class BMRCalculatorPresenter implements IBMRPresenter {

    IBMRCalculator ibmrCalculator;

    public BMRCalculatorPresenter(BMRCalculator bmrCalculator) {
        this.ibmrCalculator = bmrCalculator;
    }

    @Override
    public void onButtonClick(View view) {
        if(R.id.btn_calculator == view.getId()){
            ArrayList<String> data = ibmrCalculator.getData();
            int weight = Integer.parseInt(data.get(0));
            int height = Integer.parseInt(data.get(1));
            int age = Integer.parseInt(data.get(2));

            int bmr = (int) (655 + (4.35* weight) + (4.7*height) - (4.7*age));
            ibmrCalculator.displayResult((Integer.toString(bmr)));
        }

    }
}
