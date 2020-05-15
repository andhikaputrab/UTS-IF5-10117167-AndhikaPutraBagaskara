package com.apps.andhikaapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/*
    Developed by 10117167 - Andhika Putra Bagaskara - IF5
    02 May 2020
 */
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ImageView imageView = findViewById(R.id.splash_screen);
        int splashTime = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, WelcomeActivity.class));
                finish();
            }
        }, splashTime);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation_splash_screen);
        imageView.startAnimation(animation);
    }
}
