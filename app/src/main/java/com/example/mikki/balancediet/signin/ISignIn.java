package com.example.mikki.balancediet.signin;

import java.util.ArrayList;

public interface ISignIn {

    public ArrayList<String> bundleData();

    public void toSignUpScreen();

    public void toMainScreen();

    public void signInResult(String result);



}
