package com.example.hennadesigns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class Foot extends AppCompatActivity {

    private int[] imageIds = {

            R.drawable.foot1,
            R.drawable.foot2,
            R.drawable.foot3,
            R.drawable.foot4,
            R.drawable.foot5,
            R.drawable.foot6,
            R.drawable.foot7,
            R.drawable.foot10,
            R.drawable.foot8,
            R.drawable.foot9,
            R.drawable.foot11,
            R.drawable.foot12,
            R.drawable.foot13,
            R.drawable.foot14,
            R.drawable.foot15,
            R.drawable.foot16,
            R.drawable.foot17,
            R.drawable.foot18,
            R.drawable.foot19,
            R.drawable.foot20,
            R.drawable.foot21,
            R.drawable.foot22,
            R.drawable.foot23,
            R.drawable.foot24,
            R.drawable.foot25,
            R.drawable.foot26,
            R.drawable.foot27,
            R.drawable.foot28,
            R.drawable.foot29,
            R.drawable.foot30,
            R.drawable.foot31,
            R.drawable.foot32,
            R.drawable.foot33,
            R.drawable.foot34,
            R.drawable.foot35,
            R.drawable.foot36,
            R.drawable.foot37,
            R.drawable.foot38,
            R.drawable.foot39,
            R.drawable.foot40,
            R.drawable.foot41,
            R.drawable.foot42,
            R.drawable.foot43,
            R.drawable.foot44,
            R.drawable.foot45,
            R.drawable.foot46,
            R.drawable.foot47,
            R.drawable.foot48,
            R.drawable.foot49,
            R.drawable.foot50,
            R.drawable.foot51,
            R.drawable.foot52,
            R.drawable.foot53,
            R.drawable.foot54,
            R.drawable.foot55,
            R.drawable.foot56,
            R.drawable.foot57,
            R.drawable.foot58,
            R.drawable.foot59,
            R.drawable.foot60,
            R.drawable.foot61,
            R.drawable.foot62,
            R.drawable.foot63,
            R.drawable.foot64,
            R.drawable.foot65,
            R.drawable.foot66,
            R.drawable.foot67,
            R.drawable.foot68,
            R.drawable.foot69,
            R.drawable.foot70,
            R.drawable.foot71,
            R.drawable.foot72,
            R.drawable.foot73,
            R.drawable.foot74,
            R.drawable.foot75,
            R.drawable.foot76,
            R.drawable.foot77,
            R.drawable.foot78,
            R.drawable.foot79,
            R.drawable.foot80,
            R.drawable.foot81,
            R.drawable.foot82,
            R.drawable.foot83,
            R.drawable.foot84,
            R.drawable.foot85,
            R.drawable.foot86,
            R.drawable.foot87,
            R.drawable.foot88,
            R.drawable.foot89,
            R.drawable.foot90,
            R.drawable.foot91,
            R.drawable.foot92,
            R.drawable.foot93,
            R.drawable.foot94,
            R.drawable.foot95,
            R.drawable.foot96,
            R.drawable.foot97,
            R.drawable.foot98,


    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot);

        GridView gridView = findViewById(R.id.grid_view);
        Foot_Adapter adapter = new Foot_Adapter(this, imageIds);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Foot.this, Foot_ViewerActivity                                                                                         .class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}
