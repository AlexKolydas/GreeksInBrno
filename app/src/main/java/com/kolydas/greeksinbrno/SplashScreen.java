package com.kolydas.greeksinbrno;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 4000; //4seconds

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        final TextView greeksTxt = (TextView) findViewById(R.id.greeksTxt);
        final TextView inTxt = (TextView) findViewById(R.id.inTxt);
        final TextView brnoTxt = (TextView) findViewById(R.id.brnoTxt);

        //Display splash screen for 4 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);

        //Get visible text in 1 second
        greeksTxt.postDelayed(new Runnable() {
            @Override
            public void run() {
                greeksTxt.setVisibility(View.VISIBLE);
            }
        }, 1000);

        //Get visible text in 2 seconds
        inTxt.postDelayed(new Runnable() {
            @Override
            public void run() {
                inTxt.setVisibility(View.VISIBLE);
            }
        }, 2000);

        //Get visible text in 3 seconds
        brnoTxt.postDelayed(new Runnable() {
            @Override
            public void run() {
                brnoTxt.setVisibility(View.VISIBLE);
            }
        }, 3000);
    }

}