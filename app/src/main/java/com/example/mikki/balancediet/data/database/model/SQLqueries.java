package com.example.mikki.balancediet.data.database.model;

import android.util.Log;

public class SQLqueries {
    static SQLqueries sqLqueries = new SQLqueries();

    public SQLqueries() { }


    static public SQLqueries getSqLqueries(){
        return sqLqueries;
    }

    public String createTable(String tName, String keyID, String atr1, String atr2, String atr3, String atr4){
        String queries = "CREATE TABLE " + tName + "("
                + keyID + " INTEGER PRIMARY KEY, " + atr1 + " TEXT," + atr2 + " TEXT,"
                + atr3 + " TEXT," + atr4 + " TEXT" + ");";

        return queries;
    }

    public String createTable(String tName, String keyID, String atr1, String atr2){
        String queries = "CREATE TABLE " + tName + "("
                + keyID + " INTEGER PRIMARY KEY, " + atr1 + " TEXT," + atr2 + " TEXT" + ");";
        return queries;
    }

    public String dropTable(String tName){
        String queries = "DROP TABLE IF EXISTS " + tName +";";
        return queries;
    }

    public String readRows(String tName, String column1, String str1){
        String queries = "SELECT * FROM " + tName + " WHERE " + column1 + " = " + str1 + ";";
        Log.d("inside", "readRows: " + queries);
        return queries;
    }

    public String insertRow(String tName, String str1, String str2, String str3){
        String queries ="INSERT INTO " + tName + " VALUES (" + str1 + ", " + str2 + ", " + str3 + ");";
        return queries;
    }
    public  String insertRow(String tName, String str1, String str2){
        String queries ="INSERT INTO " + tName + " VALUES (" + str1 + ", " + str2 + ");";
        return queries;
    }



}
