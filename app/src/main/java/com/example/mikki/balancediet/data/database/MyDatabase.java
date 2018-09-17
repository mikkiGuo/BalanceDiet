package com.example.mikki.balancediet.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mikki.balancediet.data.database.model.SQLqueries;

public class MyDatabase extends SQLiteOpenHelper {

    //customer table's attribute
    public static final String MYDATABASE = "myDataBase";
    public static final String CUSTOMER = "Customer";
    public static final String USERID = "UserID";
    public static final String NAME = "Name";
    public static final String PHONE = "Phone";
    public static final String EMAIL = "email";

    //login table's attribute
    public static final String LOGIN = "Login";
    public static final String PASSWORD = "Password";

    public static final String KEY_ID = "key_id";

    public static final int VERSION = 1;

    SQLqueries sql = SQLqueries.getSqLqueries();

    public MyDatabase(Context context) {

        super(context, MYDATABASE, null, VERSION);
        Log.d("constructor", "myDatabase constructor called: hahhah");

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //String queries = sql.createTable(CUSTOMER,USERID, NAME, PHONE, EMAIL);
        //create Customer Table
        //db.execSQL(queries);
        //create Login Table
        String queries2 = sql.createTable(LOGIN, KEY_ID, USERID, PASSWORD);
        Log.d("table", "onCreate: " + queries2);

        db.execSQL(queries2);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //drop Customer and Login table
        db.execSQL(sql.dropTable(CUSTOMER));
        db.execSQL(sql.dropTable(LOGIN));
        //if drop table how about data? then we need backup.
        onCreate(db);


    }
}
