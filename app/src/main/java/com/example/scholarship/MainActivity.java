package com.example.scholarship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN_TIME_OUT=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //splash screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //title bar remove
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this,SecondActivity.class);

                startActivity(i);

                finish();
            }
        }, SPLASH_SCREEN_TIME_OUT);

    }
}