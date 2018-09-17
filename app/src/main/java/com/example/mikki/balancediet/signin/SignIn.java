package com.example.mikki.balancediet.signin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mikki.balancediet.MainActivity;
import com.example.mikki.balancediet.R;
import com.example.mikki.balancediet.signup.SignUp;

import java.util.ArrayList;

public class SignIn extends AppCompatActivity implements ISignIn{

    EditText username, password;
    SignInPresenter p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        username = findViewById(R.id.txt_username);
        password = findViewById(R.id.txt_password);

        p = new SignInPresenter(this);

    }

    public void btnClickHandler(View view) {

        p.onButtonClicked(view);

    }

    @Override
    public ArrayList<String> bundleData() {
        ArrayList<String> data = new ArrayList<String>();
        data.add(username.getText().toString());
        data.add(password.getText().toString());
        return data;
    }



    @Override
    public void toSignUpScreen() {
        //jump to Sign Up Activity
        Intent i = new Intent(this,SignUp.class);
        startActivity(i);
    }

    @Override
    public void toMainScreen() {
        //jump to Main Activity
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public void signInResult(String result) {

        Toast.makeText(this, ""+result, Toast.LENGTH_SHORT).show();
    }


}
