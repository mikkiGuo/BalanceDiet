package com.example.mikki.balancediet.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.example.mikki.balancediet.MainActivity;
import com.example.mikki.balancediet.R;
import com.example.mikki.balancediet.objectclass.Customer;
import com.example.mikki.balancediet.signin.SignIn;


public class SignUp extends AppCompatActivity implements ISignUp {


    ISignUpPresenter signUpPresenter;
    EditText uname, pw, email, phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        signUpPresenter = new SignUpPresenter(this);
        uname = findViewById(R.id.txt_username);
        pw = findViewById(R.id.txt_password);
        email = findViewById(R.id.txt_email);
        phone = findViewById(R.id.txt_phone);

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

    @Override
    public Customer bundleData() {
        String un = uname.getText().toString();
        String passw = pw.getText().toString();
        String em = email.getText().toString();
        String phN = phone.getText().toString();
        Log.d("passw", "bundleData: " + passw);
        Customer customer = new Customer(un,em,phN, passw);

        return customer;
    }
}
