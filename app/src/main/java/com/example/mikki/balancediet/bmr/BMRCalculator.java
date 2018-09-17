package com.example.mikki.balancediet.bmr;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mikki.balancediet.R;

import java.util.ArrayList;


public class BMRCalculator extends Fragment implements IBMRCalculator {

    EditText weight, height, age;
    Button btn;
    TextView result;


    BMRCalculatorPresenter p;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bmrcalculator, container, false);

        weight = view.findViewById(R.id.txt_weight);
        height = view.findViewById(R.id.txt_height);
        age = view.findViewById(R.id.txt_age);
        btn = view.findViewById(R.id.btn_calculator);
        result = view.findViewById(R.id.tv_result);

        p = new BMRCalculatorPresenter(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.onButtonClick(v);

            }
        });


        return view;
    }


    @Override
    public ArrayList<String> getData() {

        ArrayList<String> data = new ArrayList<>();
        data.add(weight.getText().toString());
        data.add(height.getText().toString());
        data.add(age.getText().toString());

        return data;
    }

    @Override
    public void displayResult(String value) {
        result.setText(value);
    }
}
