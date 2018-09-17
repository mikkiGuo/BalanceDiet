package com.example.mikki.balancediet.data.database;

import com.example.mikki.balancediet.data.IDataManager;
import com.example.mikki.balancediet.objectclass.Customer;
import com.example.mikki.balancediet.objectclass.LogInClass;

public interface IDBHelper {

    public void createRow(IDataManager.OnResponseListener listener, Customer customer);
    public void readRow(IDataManager.OnResponseListener listener, LogInClass login);
    public void readRow(IDataManager.OnResponseListener listener);
    public void updateRow();
    public void deleteRow();


}
