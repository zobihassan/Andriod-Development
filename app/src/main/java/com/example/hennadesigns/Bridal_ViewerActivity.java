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

public class Bridal_ViewerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ImageButton shareButton;
    private ImageButton downloadButton;

    private int[] imageIds = {


            R.drawable.bridal1,
            R.drawable.bridal2,
            R.drawable.bridal3,
            R.drawable.bridal4,
            R.drawable.bridal5,
            R.drawable.bridal6,
            R.drawable.bridal7,
            R.drawable.bridal10,
            R.drawable.bridal8,
            R.drawable.bridal9,
            R.drawable.bridal11,
            R.drawable.bridal12,
            R.drawable.bridal13,
            R.drawable.bridal14,
            R.drawable.bridal15,
            R.drawable.bridal16,
            R.drawable.bridal17,
            R.drawable.bridal18,
            R.drawable.bridal19,
            R.drawable.bridal20,
            R.drawable.bridal21,
            R.drawable.bridal22,
            R.drawable.bridal23,
            R.drawable.bridal24,
            R.drawable.bridal25,
            R.drawable.bridal26,
            R.drawable.bridal27,
            R.drawable.bridal28,
            R.drawable.bridal29,
            R.drawable.bridal30,
            R.drawable.bridal31,
            R.drawable.bridal32,
            R.drawable.bridal33,
            R.drawable.bridal34,
            R.drawable.bridal35,
            R.drawable.bridal36,
            R.drawable.bridal37,
            R.drawable.bridal38,
            R.drawable.bridal39,
            R.drawable.bridal40,
            R.drawable.bridal41,
            R.drawable.bridal42,
            R.drawable.bridal43,
            R.drawable.bridal44,
            R.drawable.bridal45,
            R.drawable.bridal46,
            R.drawable.bridal47,
            R.drawable.bridal48,
            R.drawable.bridal49,
            R.drawable.bridal50,
            R.drawable.bridal51,
            R.drawable.bridal52,
            R.drawable.bridal53,
            R.drawable.bridal54,
            R.drawable.bridal55,
            R.drawable.bridal56,
            R.drawable.bridal57,
            R.drawable.bridal58,
            R.drawable.bridal59,
            R.drawable.bridal60,
            R.drawable.bridal61,
            R.drawable.bridal62,
            R.drawable.bridal63,
            R.drawable.bridal64,
            R.drawable.bridal65,
            R.drawable.bridal66,
            R.drawable.bridal67,
            R.drawable.bridal68,
            R.drawable.bridal69,
            R.drawable.bridal70,
            R.drawable.bridal71,
            R.drawable.bridal72,
            R.drawable.bridal73,
            R.drawable.bridal74,
            R.drawable.bridal75,
            R.drawable.bridal76,
            R.drawable.bridal77,
            R.drawable.bridal78,
            R.drawable.bridal79,
            R.drawable.bridal80,
            R.drawable.bridal81,
            R.drawable.bridal82,
            R.drawable.bridal83,
            R.drawable.bridal84,
            R.drawable.bridal85,
            R.drawable.bridal85,
            R.drawable.bridal86,
            R.drawable.bridal87,
            R.drawable.bridal88,
            R.drawable.bridal89,
            R.drawable.bridal90,
            R.drawable.bridal91,
            R.drawable.bridal92,
            R.drawable.bridal93,
            R.drawable.bridal94,
            R.drawable.bridal95,
            R.drawable.bridal96,
            R.drawable.bridal97,
            R.drawable.bridal98,
            R.drawable.bridal99,
            R.drawable.bridal100,
            R.drawable.bridal101,
            R.drawable.bridal102,
            R.drawable.bridal103,
            R.drawable.bridal104,
            R.drawable.bridal105,
            R.drawable.bridal106,
            R.drawable.bridal107,
            R.drawable.bridal108,
            R.drawable.bridal109,
            R.drawable.bridal110,
            R.drawable.bridal111,
            R.drawable.bridal112,
            R.drawable.bridal113,
            R.drawable.bridal114,
            R.drawable.bridal115,
            R.drawable.bridal116,
            R.drawable.bridal117,
            R.drawable.bridal118,
            R.drawable.bridal119,
            R.drawable.bridal120,
            R.drawable.bridal121,
            R.drawable.bridal122,
            R.drawable.bridal123,
            R.drawable.bridal124,
            R.drawable.bridal125,
            R.drawable.bridal126,
            R.drawable.bridal127,
            R.drawable.bridal128,
            R.drawable.bridal129,
            R.drawable.bridal130,
            R.drawable.bridal131,
            R.drawable.bridal132,
            R.drawable.bridal133,
            R.drawable.bridal134,
            R.drawable.bridal135,
            R.drawable.bridal136,
            R.drawable.bridal137,
            R.drawable.bridal138,
            R.drawable.bridal139,
            R.drawable.bridal140,
            R.drawable.bridal141,
            R.drawable.bridal142,
            R.drawable.bridal143,
            R.drawable.bridal144,
            R.drawable.bridal45,
            R.drawable.bridal146,
            R.drawable.bridal147,
            R.drawable.bridal148,
            R.drawable.bridal149,
            R.drawable.bridal150,
            R.drawable.bridal151,
            R.drawable.bridal152,
            R.drawable.bridal153,
            R.drawable.bridal154,
            R.drawable.bridal155,
            R.drawable.bridal156,
            R.drawable.bridal157,
            R.drawable.bridal158,
            R.drawable.bridal159,
            R.drawable.bridal160,
            R.drawable.bridal161,
            R.drawable.bridal162,
            R.drawable.bridal163,
            R.drawable.bridal164,
            R.drawable.bridal165,
            R.drawable.bridal166,
            R.drawable.bridal167,
            R.drawable.bridal168,
            R.drawable.bridal169,
            R.drawable.bridal170,
            R.drawable.bridal171,
            R.drawable.bridal172,
            R.drawable.bridal173,
            R.drawable.bridal174,
            R.drawable.bridal175,
            R.drawable.bridal176,
            R.drawable.bridal177,
            R.drawable.bridal178,
            R.drawable.bridal179,
            R.drawable.bridal180,
            R.drawable.bridal181,
            R.drawable.bridal182,
            R.drawable.bridal183,
            R.drawable.bridal184,
            R.drawable.bridal185,
            R.drawable.bridal186,
            R.drawable.bridal187,
            R.drawable.bridal188,
            R.drawable.bridal189,
            R.drawable.bridal190,
            R.drawable.bridal191,
            R.drawable.bridal192,
            R.drawable.bridal193,
            R.drawable.bridal194,
            R.drawable.bridal195,
            R.drawable.bridal196,
            R.drawable.bridal197,
            R.drawable.bridal198,
            R.drawable.bridal199,
            R.drawable.bridal200,

    };

    private static final int REQUEST_CODE_STORAGE_PERMISSION = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bridal_viewer);

        viewPager = findViewById(R.id.view_pager);
        shareButton = findViewById(R.id.share_button);
        downloadButton = findViewById(R.id.download_button);

        List<Integer> imageList = new ArrayList<>();
        for (int imageId : imageIds) {
            imageList.add(imageId);
        }

        Bridal_PagerAdapter adapter = new Bridal_PagerAdapter(this, imageList);
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
                    Uri imageUri = FileProvider.getUriForFile(Bridal_ViewerActivity.this, getPackageName() + ".fileprovider", new File(imagePath));
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("image/*");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(Intent.createChooser(shareIntent, "Share Image"));
                } else {
                    Toast.makeText(Bridal_ViewerActivity.this, "Failed to share image", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(Bridal_ViewerActivity.this, "Image downloaded successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Bridal_ViewerActivity.this, "Failed to download image", Toast.LENGTH_SHORT).show();
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
