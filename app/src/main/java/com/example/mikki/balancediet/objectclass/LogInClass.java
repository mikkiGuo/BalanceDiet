package com.example.mikki.balancediet.objectclass;

public class LogInClass {
    String className;
    String userID;
    String password;

    public LogInClass(String userID, String password) {
        this.className = "LOGIN";
        this.userID = userID;
        this.password = password;

    }

    public String getClassName() {
        return className;
    }


    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
