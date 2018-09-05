package com.mushy.beer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class LaunchActivity extends AppCompatActivity implements Runnable {


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_launch);

        Thread thread = new Thread(this);
        thread.start();
    }

    // Splash Screen
    // Sleeps for 2.5 seconds then starts Main Activity
    @Override
    public void run () {

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            Log.e(this.getClass().getSimpleName(), "Interrupted Exception while sleeping: " + e.getMessage());
        } finally {
            Log.d(this.getClass().getSimpleName(), "Starting main activity.. ");
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

    }

}
