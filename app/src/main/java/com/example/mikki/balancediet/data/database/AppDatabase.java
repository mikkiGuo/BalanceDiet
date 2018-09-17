package com.example.mikki.balancediet.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppDatabase extends SQLiteOpenHelper {

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

    public AppDatabase(Context context) {
        super(context, MYDATABASE, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + LOGIN + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + USERID + " TEXT,"
                + PASSWORD + " TEXT" + ")";

        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + LOGIN);
        //if drop table how about data? then we need backup.
        onCreate(db);
    }
}
