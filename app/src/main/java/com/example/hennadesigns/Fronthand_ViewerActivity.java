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

public class Fronthand_ViewerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ImageButton shareButton;
    private ImageButton downloadButton;

    private int[] imageIds = {


            R.drawable.fhand1,
            R.drawable.fhand2,
            R.drawable.fhand3,
            R.drawable.fhand4,
            R.drawable.fhand5,
            R.drawable.fhand6,
            R.drawable.fhand7,
            R.drawable.fhand10,
            R.drawable.fhand8,
            R.drawable.fhand9,
            R.drawable.fhand11,
            R.drawable.fhand12,
            R.drawable.fhand13,
            R.drawable.fhand14,
            R.drawable.fhand15,
            R.drawable.fhand16,
            R.drawable.fhand17,
            R.drawable.fhand18,
            R.drawable.fhand19,
            R.drawable.fhand20,
            R.drawable.fhand21,
            R.drawable.fhand22,
            R.drawable.fhand23,
            R.drawable.fhand24,
            R.drawable.fhand25,
            R.drawable.fhand26,
            R.drawable.fhand27,
            R.drawable.fhand28,
            R.drawable.fhand29,
            R.drawable.fhand30,
            R.drawable.fhand31,
            R.drawable.fhand32,
            R.drawable.fhand33,
            R.drawable.fhand34,
            R.drawable.fhand35,
            R.drawable.fhand36,
            R.drawable.fhand37,
            R.drawable.fhand38,
            R.drawable.fhand39,
            R.drawable.fhand40,
            R.drawable.fhand41,
            R.drawable.fhand42,
            R.drawable.fhand43,
            R.drawable.fhand44,
            R.drawable.fhand45,
            R.drawable.fhand46,
            R.drawable.fhand47,
            R.drawable.fhand48,
            R.drawable.fhand49,
            R.drawable.fhand50,
            R.drawable.fhand51,
            R.drawable.fhand52,
            R.drawable.fhand53,
            R.drawable.fhand54,
            R.drawable.fhand55,
            R.drawable.fhand56,
            R.drawable.fhand57,
            R.drawable.fhand58,
            R.drawable.fhand59,
            R.drawable.fhand60,
            R.drawable.fhand61,
            R.drawable.fhand62,
            R.drawable.fhand63,
            R.drawable.fhand64,
            R.drawable.fhand65,
            R.drawable.fhand66,
            R.drawable.fhand67,
            R.drawable.fhand68,
            R.drawable.fhand69,
            R.drawable.fhand70,
            R.drawable.fhand71,
            R.drawable.fhand72,
            R.drawable.fhand73,
            R.drawable.fhand74,
            R.drawable.fhand75,
            R.drawable.fhand76,
            R.drawable.fhand77,
            R.drawable.fhand78,
            R.drawable.fhand79,
            R.drawable.fhand80,
            R.drawable.fhand81,
            R.drawable.fhand82,
            R.drawable.fhand83,
            R.drawable.fhand84,
            R.drawable.fhand85,
            R.drawable.fhand85,
            R.drawable.fhand86,
            R.drawable.fhand87,
            R.drawable.fhand88,
            R.drawable.fhand89,
            R.drawable.fhand90,
            R.drawable.fhand91,
            R.drawable.fhand92,
            R.drawable.fhand93,
            R.drawable.fhand94,
            R.drawable.fhand95,
            R.drawable.fhand96,
            R.drawable.fhand97,
            R.drawable.fhand98,
            R.drawable.fhand99,
            R.drawable.fhand100,
            R.drawable.fhand101,
            R.drawable.fhand102,
            R.drawable.fhand103,
            R.drawable.fhand104,
            R.drawable.fhand105,
            R.drawable.fhand106,
            R.drawable.fhand107,
            R.drawable.fhand108,
            R.drawable.fhand109,
            R.drawable.fhand110,
            R.drawable.fhand111,
            R.drawable.fhand112,
            R.drawable.fhand113,
            R.drawable.fhand114,
            R.drawable.fhand115,
            R.drawable.fhand116,
            R.drawable.fhand117,
            R.drawable.fhand118,
            R.drawable.fhand119,
            R.drawable.fhand120,
            R.drawable.fhand121,
            R.drawable.fhand122,
            R.drawable.fhand123,
            R.drawable.fhand124,
            R.drawable.fhand125,
            R.drawable.fhand126,
            R.drawable.fhand127,
            R.drawable.fhand128,
            R.drawable.fhand129,
            R.drawable.fhand130,
            R.drawable.fhand131,
            R.drawable.fhand132,
            R.drawable.fhand133,
            R.drawable.fhand134,
            R.drawable.fhand135,
            R.drawable.fhand136,
            R.drawable.fhand137,
            R.drawable.fhand138,
            R.drawable.fhand139,
            R.drawable.fhand140,
            R.drawable.fhand141,
            R.drawable.fhand142,
            R.drawable.fhand143,
            R.drawable.fhand144,
            R.drawable.fhand145,

    };

    private static final int REQUEST_CODE_STORAGE_PERMISSION = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fronthand_viewer);

        viewPager = findViewById(R.id.view_pager);
        shareButton = findViewById(R.id.share_button);
        downloadButton = findViewById(R.id.download_button);

        List<Integer> imageList = new ArrayList<>();
        for (int imageId : imageIds) {
            imageList.add(imageId);
        }

        Fronthand_PagerAdapter adapter = new Fronthand_PagerAdapter(this, imageList);
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
                    Uri imageUri = FileProvider.getUriForFile(Fronthand_ViewerActivity.this, getPackageName() + ".fileprovider", new File(imagePath));
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("image/*");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(Intent.createChooser(shareIntent, "Share Image"));
                } else {
                    Toast.makeText(Fronthand_ViewerActivity.this, "Failed to share image", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(Fronthand_ViewerActivity.this, "Image downloaded successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Fronthand_ViewerActivity.this, "Failed to download image", Toast.LENGTH_SHORT).show();
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
