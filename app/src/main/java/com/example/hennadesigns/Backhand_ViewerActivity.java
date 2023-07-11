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

public class Backhand_ViewerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ImageButton shareButton;
    private ImageButton downloadButton;

    private int[] imageIds = {

            R.drawable.bhand1,
            R.drawable.bhand2,
            R.drawable.bhand3,
            R.drawable.bhand4,
            R.drawable.bhand5,
            R.drawable.bhand6,
            R.drawable.bhand7,
            R.drawable.bhand8,
            R.drawable.bhand9,
            R.drawable.bhand10,
            R.drawable.bhand11,
            R.drawable.bhand12,
            R.drawable.bhand13,
            R.drawable.bhand14,
            R.drawable.bhand15,
            R.drawable.bhand16,
            R.drawable.bhand17,
            R.drawable.bhand18,
            R.drawable.bhand19,
            R.drawable.bhand20,
            R.drawable.bhand21,
            R.drawable.bhand22,
            R.drawable.bhand23,
            R.drawable.bhand24,
            R.drawable.bhand25,
            R.drawable.bhand26,
            R.drawable.bhand27,
            R.drawable.bhand28,
            R.drawable.bhand29,
            R.drawable.bhand30,
            R.drawable.bhand31,
            R.drawable.bhand32,
            R.drawable.bhand33,
            R.drawable.bhand34,
            R.drawable.bhand35,
            R.drawable.bhand36,
            R.drawable.bhand37,
            R.drawable.bhand38,
            R.drawable.bhand39,
            R.drawable.bhand40,
            R.drawable.bhand41,
            R.drawable.bhand42,
            R.drawable.bhand43,
            R.drawable.bhand44,
            R.drawable.bhand45,
            R.drawable.bhand46,
            R.drawable.bhand47,
            R.drawable.bhand48,
            R.drawable.bhand49,
            R.drawable.bhand50,
            R.drawable.bhand51,
            R.drawable.bhand52,
            R.drawable.bhand53,
            R.drawable.bhand54,
            R.drawable.bhand55,
            R.drawable.bhand56,
            R.drawable.bhand57,
            R.drawable.bhand58,
            R.drawable.bhand59,
            R.drawable.bhand60,
            R.drawable.bhand61,
            R.drawable.bhand62,
            R.drawable.bhand63,
            R.drawable.bhand64,
            R.drawable.bhand65,
            R.drawable.bhand66,
            R.drawable.bhand67,
            R.drawable.bhand68,
            R.drawable.bhand69,
            R.drawable.bhand70,
            R.drawable.bhand71,
            R.drawable.bhand72,
            R.drawable.bhand73,
            R.drawable.bhand74,
            R.drawable.bhand75,
            R.drawable.bhand76,
            R.drawable.bhand77,
            R.drawable.bhand78,
            R.drawable.bhand79,
            R.drawable.bhand80,
            R.drawable.bhand81,
            R.drawable.bhand82,
            R.drawable.bhand83,
            R.drawable.bhand84,
            R.drawable.bhand85,
            R.drawable.bhand86,
            R.drawable.bhand87,
            R.drawable.bhand88,
            R.drawable.bhand89,
            R.drawable.bhand90,
            R.drawable.bhand91,
            R.drawable.bhand92,
            R.drawable.bhand93,
            R.drawable.bhand94,
            R.drawable.bhand95,
            R.drawable.bhand96,
            R.drawable.bhand97,
            R.drawable.bhand98,
            R.drawable.bhand99,
            R.drawable.bhand100,
            R.drawable.bhand101,
            R.drawable.bhand102,
            R.drawable.bhand103,
            R.drawable.bhand104,
            R.drawable.bhand105,
            R.drawable.bhand106,
            R.drawable.bhand107,
            R.drawable.bhand108,
            R.drawable.bhand109,
            R.drawable.bhand110,
            R.drawable.bhand111,
            R.drawable.bhand112,
            R.drawable.bhand113,
            R.drawable.bhand114,
            R.drawable.bhand115,
            R.drawable.bhand116,
            R.drawable.bhand117,
            R.drawable.bhand118,
            R.drawable.bhand119,
            R.drawable.bhand120,
            R.drawable.bhand121,
            R.drawable.bhand122,
            R.drawable.bhand123,
            R.drawable.bhand124,
            R.drawable.bhand125,
            R.drawable.bhand126,
            R.drawable.bhand127,
            R.drawable.bhand128,
            R.drawable.bhand129,
            R.drawable.bhand130,
            R.drawable.bhand131,
            R.drawable.bhand132,
            R.drawable.bhand133,
            R.drawable.bhand134,
            R.drawable.bhand135,
            R.drawable.bhand136,
            R.drawable.bhand137,
            R.drawable.bhand138,
            R.drawable.bhand139,
            R.drawable.bhand140,
            R.drawable.bhand141,
            R.drawable.bhand142,
            R.drawable.bhand143,
            R.drawable.bhand145,
            R.drawable.bhand146,
            R.drawable.bhand147,
            R.drawable.bhand148,
            R.drawable.bhand149,
            R.drawable.bhand150,
            R.drawable.bhand151,
            R.drawable.bhand152,
            R.drawable.bhand153,
            R.drawable.bhand154,
            R.drawable.bhand155,
            R.drawable.bhand156,
            R.drawable.bhand157,
            R.drawable.bhand158,
            R.drawable.bhand159,
            R.drawable.bhand160,
            R.drawable.bhand161,
            R.drawable.bhand162,
            R.drawable.bhand163,
            R.drawable.bhand164,
            R.drawable.bhand165,
            R.drawable.bhand166,
            R.drawable.bhand167,
            R.drawable.bhand168,
            R.drawable.bhand169,
            R.drawable.bhand170,
            R.drawable.bhand171,
            R.drawable.bhand172,
            R.drawable.bhand173,
            R.drawable.bhand174,
            R.drawable.bhand175,
            R.drawable.bhand176,
            R.drawable.bhand177,
            R.drawable.bhand178,
            R.drawable.bhand179,
            R.drawable.bhand180,
            R.drawable.bhand181,
            R.drawable.bhand182,
            R.drawable.bhand183,
            R.drawable.bhand184,
            R.drawable.bhand185,
            R.drawable.bhand186,
            R.drawable.bhand187,
            R.drawable.bhand189,
            R.drawable.bhand190,
            R.drawable.bhand191,
            R.drawable.bhand192,
            R.drawable.bhand193,
            R.drawable.bhand194,
            R.drawable.bhand195,
            R.drawable.bhand196,
            R.drawable.bhand197,
            R.drawable.bhand198,
            R.drawable.bhand199,
            R.drawable.bhand200,
    };

    private static final int REQUEST_CODE_STORAGE_PERMISSION = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backhand_viewer);

        viewPager = findViewById(R.id.view_pager);
        shareButton = findViewById(R.id.share_button);
        downloadButton = findViewById(R.id.download_button);

        List<Integer> imageList = new ArrayList<>();
        for (int imageId : imageIds) {
            imageList.add(imageId);
        }

        Backhand_PagerAdapter adapter = new Backhand_PagerAdapter(this, imageList);
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
                    Uri imageUri = FileProvider.getUriForFile(Backhand_ViewerActivity.this, getPackageName() + ".fileprovider", new File(imagePath));
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("image/*");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(Intent.createChooser(shareIntent, "Share Image"));
                } else {
                    Toast.makeText(Backhand_ViewerActivity.this, "Failed to share image", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(Backhand_ViewerActivity.this, "Image downloaded successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Backhand_ViewerActivity.this, "Failed to download image", Toast.LENGTH_SHORT).show();
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
