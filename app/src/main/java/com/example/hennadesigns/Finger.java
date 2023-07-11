package com.example.hennadesigns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class Finger extends AppCompatActivity {

    private int[] imageIds = {

            R.drawable.finger1,
            R.drawable.finger2,
            R.drawable.finger3,
            R.drawable.finger4,
            R.drawable.finger5,
            R.drawable.finger6,
            R.drawable.finger7,
            R.drawable.finger10,
            R.drawable.finger8,
            R.drawable.finger9,
            R.drawable.finger11,
            R.drawable.finger12,
            R.drawable.finger13,
            R.drawable.finger14,
            R.drawable.finger15,
            R.drawable.finger16,
            R.drawable.finger17,
            R.drawable.finger18,
            R.drawable.finger19,
            R.drawable.finger20,
            R.drawable.finger21,
            R.drawable.finger22,
            R.drawable.finger23,
            R.drawable.finger24,
            R.drawable.finger25,
            R.drawable.finger26,
            R.drawable.finger27,
            R.drawable.finger28,
            R.drawable.finger29,
            R.drawable.finger30,
            R.drawable.finger31,
            R.drawable.finger32,
            R.drawable.finger33,
            R.drawable.finger34,
            R.drawable.finger35,
            R.drawable.finger36,
            R.drawable.finger37,
            R.drawable.finger38,
            R.drawable.finger39,
            R.drawable.finger40,
            R.drawable.finger41,
            R.drawable.finger42,
            R.drawable.finger43,
            R.drawable.finger44,
            R.drawable.finger45,
            R.drawable.finger46,
            R.drawable.finger47,
            R.drawable.finger48,
            R.drawable.finger49,
            R.drawable.finger50,
            R.drawable.finger51,
            R.drawable.finger52,
            R.drawable.finger53,
            R.drawable.finger54,
            R.drawable.finger55,
            R.drawable.finger56,
            R.drawable.finger57,
            R.drawable.finger58,
            R.drawable.finger59,
            R.drawable.finger60,
            R.drawable.finger61,
            R.drawable.finger62,
            R.drawable.finger63,
            R.drawable.finger64,
            R.drawable.finger65,
            R.drawable.finger66,
            R.drawable.finger67,
            R.drawable.finger68,
            R.drawable.finger69,
            R.drawable.finger70,
            R.drawable.finger71,
            R.drawable.finger72,
            R.drawable.finger73,
            R.drawable.finger74,
            R.drawable.finger75,
            R.drawable.finger76,
            R.drawable.finger77,
            R.drawable.finger78,
            R.drawable.finger79,
            R.drawable.finger80,
            R.drawable.finger81,
            R.drawable.finger82,
            R.drawable.finger83,
            R.drawable.finger84,
            R.drawable.finger85,
            R.drawable.finger86,
            R.drawable.finger87,
            R.drawable.finger88,
            R.drawable.finger89,
            R.drawable.finger90,
            R.drawable.finger91,
            R.drawable.finger92,
            R.drawable.finger93,
            R.drawable.finger94,
            R.drawable.finger95,
            R.drawable.finger96,
            R.drawable.finger97,
            R.drawable.finger98,
            R.drawable.finger99,
            R.drawable.finger100,
            R.drawable.finger101,
            R.drawable.finger102,
            R.drawable.finger103,
            R.drawable.finger104,
            R.drawable.finger105,
            R.drawable.finger106,
            R.drawable.finger107,
            R.drawable.finger108,
            R.drawable.finger109,
            R.drawable.finger110,
            R.drawable.finger111,
            R.drawable.finger112,
            R.drawable.finger113,
            R.drawable.finger114,
            R.drawable.finger115,
            R.drawable.finger116,
            R.drawable.finger117,
            R.drawable.finger118,
            R.drawable.finger119,
            R.drawable.finger120,
            R.drawable.finger121,
            R.drawable.finger122,
            R.drawable.finger123,
            R.drawable.finger124,
            R.drawable.finger125,
            R.drawable.finger126,
            R.drawable.finger127,
            R.drawable.finger128,
            R.drawable.finger138,
            R.drawable.finger139,
            R.drawable.finger140,
            R.drawable.finger141,
            R.drawable.finger142,
            R.drawable.finger143,
            R.drawable.finger144,
            R.drawable.finger145,
            R.drawable.finger146,
            R.drawable.finger147,
            R.drawable.finger148,
            R.drawable.finger149,


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger);

        GridView gridView = findViewById(R.id.grid_view);
        Finger_Adapter adapter = new Finger_Adapter(this, imageIds);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Finger.this, Finger_ViewerActivity                                                                                         .class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}
