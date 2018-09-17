package com.example.mikki.balancediet.signup;


import android.view.View;

import com.example.mikki.balancediet.R;

import java.util.ArrayList;

public class SignUpPresenter implements ISignUpPresenter {

        ISignUp iSignUp;
    public SignUpPresenter(SignUp signUpActivity) {
        iSignUp = signUpActivity;

    }
    @Override
    public void onButtonClicked(View view) {
        if(view.getId() == R.id.btn_signup){
            iSignUp.getMessage("sucess");
            iSignUp.toSignInScreen();
        }

    }
}
