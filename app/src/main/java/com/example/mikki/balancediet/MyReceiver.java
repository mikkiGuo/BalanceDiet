package com.example.mikki.balancediet;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    final SmsManager sms = SmsManager.getDefault();

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "sms received", Toast.LENGTH_SHORT).show();

        //final Bundle bundle = intent.getExtras();



    }
}
