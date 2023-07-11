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

public class GolTikki_ViewerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ImageButton shareButton;
    private ImageButton downloadButton;

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

    private static final int REQUEST_CODE_STORAGE_PERMISSION = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goltikki_viewer);

        viewPager = findViewById(R.id.view_pager);
        shareButton = findViewById(R.id.share_button);
        downloadButton = findViewById(R.id.download_button);

        List<Integer> imageList = new ArrayList<>();
        for (int imageId : imageIds) {
            imageList.add(imageId);
        }

        GolTikki_PagerAdapter adapter = new GolTikki_PagerAdapter(this, imageList);
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
                    Uri imageUri = FileProvider.getUriForFile(GolTikki_ViewerActivity.this, getPackageName() + ".fileprovider", new File(imagePath));
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("image/*");
                    shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(Intent.createChooser(shareIntent, "Share Image"));
                } else {
                    Toast.makeText(GolTikki_ViewerActivity.this, "Failed to share image", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(GolTikki_ViewerActivity.this, "Image downloaded successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(GolTikki_ViewerActivity.this, "Failed to download image", Toast.LENGTH_SHORT).show();
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
