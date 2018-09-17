package com.example.mikki.balancediet.data.database;

import android.database.sqlite.SQLiteDatabase;

import com.example.mikki.balancediet.data.IDataManager;
import com.example.mikki.balancediet.signin.LogInClass;

public interface IDBHelper {

    public void createRow();
    public void readRow(IDataManager.OnResponseListener listener, LogInClass login);
    public void readRow(IDataManager.OnResponseListener listener);
    public void updateRow();
    public void deleteRow();


}
