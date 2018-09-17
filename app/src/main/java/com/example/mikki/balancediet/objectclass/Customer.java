package com.example.mikki.balancediet.objectclass;

import android.util.Log;

public class Customer {
    private  String userID, email, phone, password;

    public Customer(String userID, String email, String phone, String password) {
        if(password == null){
            Log.d("null", "Customer: null");
            this.password = null;
        }else{
            this.password = password;
        }
        this.userID = userID;
        this.email = email;
        this.phone = phone;

    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
