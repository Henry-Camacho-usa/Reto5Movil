package com.example.reto1movil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private ProgressBar Pb;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Pb = (ProgressBar) findViewById(R.id.progressBar2);
        setProgressValue((5));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
            }
        },6750);

        //Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();
        ThreadWebService TWS = new ThreadWebService();
        TWS.context = getBaseContext();
        TWS.run();
    }

    private void setProgressValue(final int progress) {

        // set the progress
        Pb.setProgress(progress);
        // thread is used to change the progress value
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setProgressValue(progress + 8);
            }
        });
        thread.start();
    }
}
