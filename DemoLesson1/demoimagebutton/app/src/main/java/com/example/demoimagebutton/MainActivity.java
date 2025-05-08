package com.example.demoimagebutton;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView hinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        hinh=findViewById(R.id.imageView);
    }

    public void facebook(View view) {
        hinh.setImageResource(R.drawable.facebook);
    }

    public void twitter(View view) {
        hinh.setImageResource(R.drawable.twitter);
    }
}