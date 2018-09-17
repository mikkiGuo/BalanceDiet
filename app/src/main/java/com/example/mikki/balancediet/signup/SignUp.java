package com.example.mikki.balancediet.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.example.mikki.balancediet.R;
import com.example.mikki.balancediet.signin.SignIn;


public class SignUp extends AppCompatActivity implements ISignUp {


    SignUpPresenter signUpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpPresenter = new SignUpPresenter(this);

    }

    public void btnClickHandler(View view) {
        signUpPresenter.onButtonClicked(view);

    }



    @Override
    public void getMessage(String msg) {
        Toast.makeText(this, "" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toSignInScreen() {
        //jump to Sign In Activity
        Intent i = new Intent(this, SignIn.class);
        startActivity(i);
    }
}
