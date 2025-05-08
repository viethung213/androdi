package com.example.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        Log.e("aaa", "onCreate: Main Activity 2" );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("aaa", "onStart: Main Activity 2");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("aaa", "onRestart: Main Activity 2");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("aaa", "onResume: Main Activity 2");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("aaa", "onPause: Main Activity 2");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("aaa", "onStop: Main Activity 2");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("aaa", "onDestroy: Main Activity 2");
    }

    public void ToActivity1(View view) {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
    }

    public void close(View view) {
        finish();
    }
}