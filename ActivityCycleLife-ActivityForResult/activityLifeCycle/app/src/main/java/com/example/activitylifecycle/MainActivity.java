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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.e("aaa", "onCreate: Main Activity  ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("aaa", "onStart: Main Activity  ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("aaa", "onRestart: Main Activity  ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("aaa", "onResume: Main Activity  ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("aaa", "onPause: Main Activity  ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("aaa", "onStop: Main Activity  ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("aaa", "onDestroy: Main Activity  ");
    }

    public void ToActivity2(View view) {
        Intent intent= new Intent(MainActivity.this, MainActivity2.class);
        startActivity(intent);
    }

    public void CloseMainActivity(View view) {
        finish();
    }
}