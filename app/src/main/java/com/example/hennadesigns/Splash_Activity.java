package com.example.hennadesigns;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class Splash_Activity extends AppCompatActivity {

    int SPLASH_TIME =3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);



        new Handler(getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent mySuperIntent = new Intent(Splash_Activity.this, Intro_Screen.class);
                startActivity(mySuperIntent);


                finish();

            }
        }, SPLASH_TIME);

        // Declaring the animation view
        LottieAnimationView animationView
                = findViewById(R.id.animation_view);
        animationView
                .addAnimatorUpdateListener(
                        (animation) -> {
                            // Do something.
                        });
        animationView
                .playAnimation();

        if (animationView.isAnimating()) {
            // Do something.
        }


    }

}