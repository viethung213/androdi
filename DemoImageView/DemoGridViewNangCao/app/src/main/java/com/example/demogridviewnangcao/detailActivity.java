package com.example.demogridviewnangcao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class detailActivity extends AppCompatActivity {
    ImageView hinh;
    TextView ten;
    TextView soluong;
    TextView diachi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        hinh =findViewById(R.id.imageView2);
        ten =findViewById(R.id.textView4);
        soluong =findViewById(R.id.textView5);
        diachi =findViewById(R.id.textView6);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("class");
        phantu phantu = (phantu) bundle.getSerializable("ha");
        hinh.setImageResource(phantu.getHinh());
        ten.setText(phantu.getTen());
        soluong.setText(phantu.getSoluong());
        diachi.setText(phantu.getDiachi());
    }

    public void back(View view) {
        finish();
    }
}