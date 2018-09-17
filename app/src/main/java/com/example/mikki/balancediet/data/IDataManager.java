package com.example.mikki.balancediet.data;

import com.example.mikki.balancediet.data.database.IDBHelper;

public interface IDataManager extends IDBHelper {

    interface OnResponseListener{ /// switch board
        public void getResult(String result);

    }
}
