package com.example.hennadesigns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;

public class Arm extends AppCompatActivity {

    private int[] imageIds = {


            R.drawable.zarm1,
            R.drawable.zarm2,
            R.drawable.zarm3,
            R.drawable.zarm4,
            R.drawable.zarm5,
            R.drawable.zarm6,
            R.drawable.zarm7,
            R.drawable.zarm10,
            R.drawable.zarm8,
            R.drawable.zarm9,
            R.drawable.zarm11,
            R.drawable.zarm12,
            R.drawable.zarm13,
            R.drawable.zarm14,
            R.drawable.zarm15,
            R.drawable.zarm16,
            R.drawable.zarm17,
            R.drawable.zarm18,
            R.drawable.zarm19,
            R.drawable.zarm20,
            R.drawable.zarm21,
            R.drawable.zarm22,
            R.drawable.zarm23,
            R.drawable.zarm24,
            R.drawable.zarm25,
            R.drawable.zarm26,
            R.drawable.zarm27,
            R.drawable.zarm28,
            R.drawable.zarm29,
            R.drawable.zarm30,
            R.drawable.zarm31,
            R.drawable.zarm32,
            R.drawable.zarm33,
            R.drawable.zarm34,
            R.drawable.zarm35,
            R.drawable.zarm36,
            R.drawable.zarm37,
            R.drawable.zarm38,
            R.drawable.zarm39,
            R.drawable.zarm40,
            R.drawable.zarm41,
            R.drawable.zarm42,
            R.drawable.zarm43,
            R.drawable.zarm44
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm);

        GridView gridView = findViewById(R.id.grid_view);
        Arm_Adapter adapter = new Arm_Adapter(this, imageIds);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Arm.this, Arm_ViewerActivity                                                                                         .class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}
