package com.example.hennadesigns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class GolTikki extends AppCompatActivity {

    private int[] imageIds = {

            R.drawable.tikki1,
            R.drawable.tikki2,
            R.drawable.tikki3,
            R.drawable.tikki4,
            R.drawable.tikki5,
            R.drawable.tikki6,
            R.drawable.tikki7,
            R.drawable.tikki10,
            R.drawable.tikki8,
            R.drawable.tikki9,
            R.drawable.tikki11,
            R.drawable.tikki12,
            R.drawable.tikki13,
            R.drawable.tikki14,
            R.drawable.tikki15,
            R.drawable.tikki16,
            R.drawable.tikki17,
            R.drawable.tikki18,
            R.drawable.tikki19,
            R.drawable.tikki20,
            R.drawable.tikki21,
            R.drawable.tikki22,
            R.drawable.tikki23,
            R.drawable.tikki24,
            R.drawable.tikki25,
            R.drawable.tikki26,
            R.drawable.tikki27,
            R.drawable.tikki28,
            R.drawable.tikki29,
            R.drawable.tikki30,
            R.drawable.tikki31,
            R.drawable.tikki32,
            R.drawable.tikki33,
            R.drawable.tikki34,
            R.drawable.tikki35,
            R.drawable.tikki36,
            R.drawable.tikki37,
            R.drawable.tikki38,
            R.drawable.tikki39,
            R.drawable.tikki40,
            R.drawable.tikki41,
            R.drawable.tikki42,
            R.drawable.tikki43,
            R.drawable.tikki44,
            R.drawable.tikki45,
            R.drawable.tikki46,
            R.drawable.tikki47,
            R.drawable.tikki48,
            R.drawable.tikki49,
            R.drawable.tikki50,
            R.drawable.tikki51,
            R.drawable.tikki52,
            R.drawable.tikki53,
            R.drawable.tikki54,
            R.drawable.tikki55,
            R.drawable.tikki56,
            R.drawable.tikki57,
            R.drawable.tikki58,
            R.drawable.tikki59,
            R.drawable.tikki60,
            R.drawable.tikki61,
            R.drawable.tikki62,
            R.drawable.tikki63,
            R.drawable.tikki64,
            R.drawable.tikki65,
            R.drawable.tikki66,
            R.drawable.tikki67,
            R.drawable.tikki68,
            R.drawable.tikki69,
            R.drawable.tikki70,
            R.drawable.tikki71,
            R.drawable.tikki72,
            R.drawable.tikki73,
            R.drawable.tikki74,
            R.drawable.tikki75,
            R.drawable.tikki76,
            R.drawable.tikki77,
            R.drawable.tikki78,
            R.drawable.tikki79,
            R.drawable.tikki80,
            R.drawable.tikki81,
            R.drawable.tikki82,
            R.drawable.tikki83,
            R.drawable.tikki84,
            R.drawable.tikki85,
            R.drawable.tikki86,
            R.drawable.tikki87,
            R.drawable.tikki88,
            R.drawable.tikki89,
            R.drawable.tikki90,
            R.drawable.tikki91,
            R.drawable.tikki92,
            R.drawable.tikki93,
            R.drawable.tikki94,
            R.drawable.tikki95,
            R.drawable.tikki96,
            R.drawable.tikki97,
            R.drawable.tikki98,
            R.drawable.tikki99,
            R.drawable.tikki100,
            R.drawable.tikki101,
            R.drawable.tikki102,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goltikki);

        GridView gridView = findViewById(R.id.grid_view);
        GolTikki_Adapter adapter = new GolTikki_Adapter(this, imageIds);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GolTikki.this, GolTikki_ViewerActivity                                                                                         .class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }
}
