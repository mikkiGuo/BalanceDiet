package com.example.mikki.balancediet.signin;

import android.util.Log;
import android.view.View;

import com.example.mikki.balancediet.R;
import com.example.mikki.balancediet.data.DataManager;
import com.example.mikki.balancediet.data.IDataManager;
import com.example.mikki.balancediet.objectclass.LogInClass;


import java.util.ArrayList;


public class SignInPresenter implements ISignInPresenter, IDataManager.OnResponseListener{

    ISignIn signIn;
    IDataManager dataManager;


    public SignInPresenter(SignIn signInActivity) {
        signIn = signInActivity;
        dataManager = new DataManager(signInActivity);
    }

    @Override
    public void onButtonClicked(View v) {

        switch (v.getId()){
            case R.id.btn_signin:
                ArrayList<String> data = signIn.bundleData();
                Log.d("presenter", "onButtonClicked: " + data.get(0)+"  " + data.get(1));
                LogInClass logIn = new LogInClass(data.get(0), data.get(1));
                //dataManager.readRow(this);
                //dataManager.readRow(this, logIn);
                signIn.toMainScreen();
                break;
            case R.id.btn_signup:
                signIn.toSignUpScreen();
                default:
                    break;
        }



    }


    @Override
    public void getResult(String result) {
        signIn.signInResult(result);
    }
}
