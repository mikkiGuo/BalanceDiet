package com.example.mikki.balancediet;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mikki.balancediet.signin.SignIn;

public class SplashActivity extends AppCompatActivity {

    TextView display_tv;
    //ProgressDialog pd;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        display_tv = findViewById(R.id.tv_display);
        progressBar = findViewById(R.id.progressBar);

        MyAsynTask asyncTask = new MyAsynTask();
        asyncTask.execute("COMPLETE");



    }

    private class MyAsynTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            /*pd = new ProgressDialog(SplashActivity.this);
            pd.setTitle("Progress Dialog");
            pd.setMessage("Please wait...");
            pd.setCancelable(false);
            pd.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                    cancel(true);
                }
            });

            pd.show();*/


        }

        @Override
        protected String doInBackground(String... strings) {
            for(int i = 0; i < 100; i++){
                if(this.isCancelled()){
                    break;
                }
                int value = i;
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //pass data to UI
                publishProgress(value);
                progressBar.setProgress(value);


            }
            String result = strings[0];

            return result;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            display_tv.setText(values[0] + "% downloaded");

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            //pd.cancel();
            display_tv.setText(s);

            Intent intent = new Intent(SplashActivity.this, SignIn.class);
            startActivity(intent);


        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            display_tv.setText("Cancelled");
        }
    }


}
