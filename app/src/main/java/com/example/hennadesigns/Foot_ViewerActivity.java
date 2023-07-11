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

public class Foot_ViewerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ImageButton shareButton;
    private ImageButton downloadButton;

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

    private static final int REQUEST_CODE_STORAGE_PERMISSION = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foot_viewer);

        viewPager = findViewById(R.id.view_pager);
        shareButton = findViewById(R.id.share_button);
        downloadButton = findViewById(R.id.download_button);

        List<Integer> imageList = new ArrayList<>();
        for (int imageId : imageIds) {
            imageList.add(imageId);
        }

        Foot_PagerAdapter adapter = new Foot_PagerAdapter(this, imageList);
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
                    Uri imageUri = FileProvider.getUriForFile(Foot_ViewerActivity.this, getPackageName() + ".fileprovider", new File(imagePath));
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("image/*");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(Intent.createChooser(shareIntent, "Share Image"));
                } else {
                    Toast.makeText(Foot_ViewerActivity.this, "Failed to share image", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(Foot_ViewerActivity.this, "Image downloaded successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Foot_ViewerActivity.this, "Failed to download image", Toast.LENGTH_SHORT).show();
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
