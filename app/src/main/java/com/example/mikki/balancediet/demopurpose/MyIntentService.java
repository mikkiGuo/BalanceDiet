package com.example.mikki.balancediet.demopurpose;

import android.app.IntentService;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.mikki.balancediet.R;

//import org.greenrobot.eventbus.EventBus;
//import org.greenrobot.eventbus.Subscribe;

public class MyIntentService extends IntentService {
    MediaPlayer mediaPlayer;

    public MyIntentService() {
        //giving name for this thread
        super("mythread");
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //whatever here will get executed in the separate thread
        //EventBus.getDefault().register(this);
        try {
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //we will not see this toast because this is running on the separate thread not in Main thread / UI.
        Toast.makeText(MyIntentService.this, "Intent Service OnHandle", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onCreate() {
        mediaPlayer=MediaPlayer.create(MyIntentService.this, R.raw.perfect);
        Toast.makeText(MyIntentService.this, "Intent-onCreate", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    //onStart is the old version, onstartcommand is the newest version


    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        mediaPlayer.start();
        Toast.makeText(MyIntentService.this, "Intent-onStart", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        mediaPlayer.stop();
        Toast.makeText(MyIntentService.this, "Intent-onDestroy", Toast.LENGTH_SHORT).show();

        super.onDestroy();
    }

    /*@Subscribe
    public void mySubscriber(){

    }*/

}
