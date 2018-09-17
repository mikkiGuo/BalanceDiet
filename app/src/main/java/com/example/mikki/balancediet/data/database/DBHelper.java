package com.example.mikki.balancediet.data.database;

import android.app.NotificationManager;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.mikki.balancediet.data.IDataManager;
import com.example.mikki.balancediet.data.database.model.SQLqueries;
import com.example.mikki.balancediet.signin.LogInClass;
import com.example.mikki.balancediet.signin.SignInPresenter;

public class DBHelper implements IDBHelper {

    MyDatabase myDatabase;
    static SQLiteDatabase db;

    SQLqueries sql = SQLqueries.getSqLqueries();

    public DBHelper(Context context) {
        myDatabase = new MyDatabase(context);
        db = myDatabase.getWritableDatabase();
    }

    @Override
    public void createRow() {

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
