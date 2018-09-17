package com.example.mikki.balancediet.demopurpose;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mikki.balancediet.R;
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
