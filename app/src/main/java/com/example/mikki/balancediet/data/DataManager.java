package com.example.mikki.balancediet.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.mikki.balancediet.data.database.DBHelper;
import com.example.mikki.balancediet.data.database.IDBHelper;
import com.example.mikki.balancediet.signin.LogInClass;

public class DataManager implements IDataManager{

    IDBHelper dbHelper;

    public DataManager(Context context) {
        dbHelper = new DBHelper(context);
    }

    @Override
    public void createRow() {

    }

    @Override
    public void readRow(OnResponseListener listener, LogInClass login) {
        dbHelper.readRow(listener,login);
    }

    @Override
    public void readRow(OnResponseListener listener) {
        dbHelper.readRow(listener);
    }

    @Override
    public void updateRow() {

    }

    @Override
    public void deleteRow() {

    }
}
