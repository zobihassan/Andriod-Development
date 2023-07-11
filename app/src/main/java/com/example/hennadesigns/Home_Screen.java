package com.example.hennadesigns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Home_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        ImageView imageView1 = findViewById(R.id.iv1);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Screen.this, Back_Hand.class);
                startActivity(intent);
            }
        });

        ImageView imageView2 = findViewById(R.id.iv2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Screen.this, Finger.class);
                startActivity(intent);
            }
        });

        ImageView imageView3 = findViewById(R.id.iv3);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Screen.this, Foot.class);
                startActivity(intent);
            }
        });

        ImageView imageView4 = findViewById(R.id.iv4);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Screen.this, GolTikki.class);
                startActivity(intent);
            }
        });

        ImageView imageView5 = findViewById(R.id.iv5);
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Screen.this, Fronthand.class);
                startActivity(intent);
            }
        });

        ImageView imageView6 = findViewById(R.id.iv6);
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Screen.this, Bridal.class);
                startActivity(intent);
            }
        });

        ImageView imageView7 = findViewById(R.id.iv7);
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Screen.this, Eid.class);
                startActivity(intent);
            }
        });

        ImageView imageView8 = findViewById(R.id.iv8);
        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home_Screen.this, Arm.class);
                startActivity(intent);
            }
        });
    }
}
