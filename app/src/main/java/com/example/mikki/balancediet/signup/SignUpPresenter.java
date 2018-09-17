package com.example.mikki.balancediet.signup;


import android.content.Context;
import android.view.View;

import com.example.mikki.balancediet.R;
import com.example.mikki.balancediet.data.DataManager;
import com.example.mikki.balancediet.data.IDataManager;
import com.example.mikki.balancediet.objectclass.Customer;

import java.util.ArrayList;

public class SignUpPresenter implements ISignUpPresenter, IDataManager.OnResponseListener {

    ISignUp iSignUp;
    IDataManager dataManager;


    public SignUpPresenter(SignUp signUpActivity) {
        iSignUp = signUpActivity;
        dataManager = new DataManager(signUpActivity);

    }
    @Override
    public void onButtonClicked(View view) {
        if(view.getId() == R.id.btn_signup){
            //iSignUp.getMessage("sucess");
            Customer customer = iSignUp.bundleData();
            if(customer.getUserID() != null && customer.getPassword() != null){
                dataManager.createRow(this, customer);
                iSignUp.toSignInScreen();
            }else{
                getResult("Failure");
            }

        }


    }

    @Override
    public void getResult(String result) {
        iSignUp.getMessage(result);
    }
}
