package com.example.hennadesigns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class Eid extends AppCompatActivity {

    private int[] imageIds = {

            R.drawable.special1,
            R.drawable.special2,
            R.drawable.special3,
            R.drawable.special4,
            R.drawable.special5,
            R.drawable.special6,
            R.drawable.special7,
            R.drawable.special10,
            R.drawable.special8,
            R.drawable.special9,
            R.drawable.special11,
            R.drawable.special12,
            R.drawable.special13,
            R.drawable.special14,
            R.drawable.special15,
            R.drawable.special16,
            R.drawable.special17,
            R.drawable.special18,
            R.drawable.special19,
            R.drawable.special20,
            R.drawable.special21,
            R.drawable.special22,
            R.drawable.special23,
            R.drawable.special24,
            R.drawable.special25,
            R.drawable.special26,
            R.drawable.special27,
            R.drawable.special28,
            R.drawable.special29,
            R.drawable.special30,
            R.drawable.special31,
            R.drawable.special32,
            R.drawable.special33,
            R.drawable.special34,
            R.drawable.special35,
            R.drawable.special36,
            R.drawable.special37,
            R.drawable.special38,
            R.drawable.special39,
            R.drawable.special40,
            R.drawable.special41,
            R.drawable.special42,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eid);

        GridView gridView = findViewById(R.id.grid_view);
        Eid_Adapter adapter = new Eid_Adapter(this, imageIds);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Eid.this, Eid_ViewerActivity                                                                                         .class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}
