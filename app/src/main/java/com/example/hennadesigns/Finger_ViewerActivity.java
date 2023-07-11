package com.example.hennadesigns;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.viewpager.widget.ViewPager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Finger_ViewerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ImageButton shareButton;
    private ImageButton downloadButton;

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

    private static final int REQUEST_CODE_STORAGE_PERMISSION = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_viewer);

        viewPager = findViewById(R.id.view_pager);
        shareButton = findViewById(R.id.share_button);
        downloadButton = findViewById(R.id.download_button);

        List<Integer> imageList = new ArrayList<>();
        for (int imageId : imageIds) {
            imageList.add(imageId);
        }

        Finger_PagerAdapter adapter = new Finger_PagerAdapter(this, imageList);
        viewPager.setAdapter(adapter);

        // Retrieve the clicked position from the intent
        int position = getIntent().getIntExtra("position", 0);
        viewPager.setCurrentItem(position); // Set the initial item of the ViewPager to the clicked position


        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = viewPager.getCurrentItem();
                int imageId = imageList.get(currentPosition);

                BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(imageId);
                Bitmap bitmap = bitmapDrawable.getBitmap();

                String imagePath = saveImageToExternalStorage(bitmap);
                if (imagePath != null) {
                    Uri imageUri = FileProvider.getUriForFile(Finger_ViewerActivity.this, getPackageName() + ".fileprovider", new File(imagePath));
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("image/*");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(Intent.createChooser(shareIntent, "Share Image"));
                } else {
                    Toast.makeText(Finger_ViewerActivity.this, "Failed to share image", Toast.LENGTH_SHORT).show();
                }
            }
        });

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = viewPager.getCurrentItem();
                int imageId = imageList.get(currentPosition);

                BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(imageId);
                Bitmap bitmap = bitmapDrawable.getBitmap();

                if (saveImageToExternalStorage(bitmap) != null) {
                    Toast.makeText(Finger_ViewerActivity.this, "Image downloaded successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Finger_ViewerActivity.this, "Failed to download image", Toast.LENGTH_SHORT).show();
                }
            }
        });

        requestStoragePermission();
    }

    private void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_STORAGE_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_STORAGE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
            } else {
                Toast.makeText(this, "Storage permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private String saveImageToExternalStorage(Bitmap image) {
        String imagePath = null;
        try {
            File directory = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MyApp");
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File file = new File(directory, "image_" + System.currentTimeMillis() + ".jpg");
            FileOutputStream outputStream = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
            outputStream.flush();
            outputStream.close();

            imagePath = file.getAbsolutePath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imagePath;
    }
}
