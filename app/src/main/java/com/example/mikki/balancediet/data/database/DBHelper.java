package com.example.mikki.balancediet.data.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.mikki.balancediet.data.IDataManager;
import com.example.mikki.balancediet.data.database.model.SQLqueries;
import com.example.mikki.balancediet.objectclass.Customer;
import com.example.mikki.balancediet.objectclass.LogInClass;

public class DBHelper implements IDBHelper {

    //MyDatabase myDatabase;
    AppDatabase myDatabase;
    static SQLiteDatabase db;

    SQLqueries sql = SQLqueries.getSqLqueries();

    public DBHelper(Context context) {
        myDatabase = new AppDatabase(context);
        db = myDatabase.getWritableDatabase();
    }


    @Override
    public void createRow(IDataManager.OnResponseListener listener, Customer customer) {
        listener.getResult("Sucessful");

        /*String queries = sql.insertRow("Customer",
                customer.getUserID(), customer.getEmail(), customer.getPhone());
        Log.d("cus", "createRow: " + queries);
        String queries2 = sql.insertRow("Login", customer.getUserID(), customer.getPassword());
        Log.d("login", "createRow: " + queries2);
        //db.execSQL(queries);
        db.execSQL(queries2);*/
    }

    @Override
    public void readRow(IDataManager.OnResponseListener listener, LogInClass login) {
        Log.d("readRow", "readRow: ......");
        //db = getWritableDatabase();
        //listener.getResult("Test");
        String queries = sql.readRows(myDatabase.LOGIN, myDatabase.USERID, login.getUserID());
        String pw = myDatabase.PASSWORD;
        Log.d("show", "readRow: " + queries);


        Cursor cursor = db.rawQuery(queries,null);

        if(cursor.moveToFirst()){
            Log.d("test2", "readRow: eeeeee");
            String password = cursor.getString(cursor.getColumnIndex(myDatabase.PASSWORD));
            if(password.equals(login.getPassword())){
                listener.getResult("Success");
            }else{
                listener.getResult("Failure");
            }
        }
        else{
            Log.d("test3", "readRow: nononono");
            listener.getResult("Failure");
        }


    }

    @Override
    public void readRow(IDataManager.OnResponseListener listener) {
        listener.getResult("Test");
    }


    @Override
    public void updateRow() {

    }

    @Override
    public void deleteRow() {

    }
}
