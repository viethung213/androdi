package com.example.demogridviewnangcao;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<phantu> phantus;
    GridView view;
    gridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        view =findViewById(R.id.no);
        phantus = new ArrayList<>();
        phantus.add(new phantu("no1","5","mỹ",R.drawable.img));
        phantus.add(new phantu("no2","5","mỹ",R.drawable.img_1));
        phantus.add(new phantu("no3","5","mỹ",R.drawable.img_2));
        phantus.add(new phantu("no4","5","mỹ",R.drawable.img_3));
        phantus.add(new phantu("no5","5","mỹ",R.drawable.img_4));

        adapter = new gridAdapter(this,R.layout.activity_phantu,phantus);
        view.setAdapter(adapter);
        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                phantu phantui = phantus.get(i);
                Intent intent = new Intent(MainActivity.this, detailActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("ha",phantui);
                intent.putExtra("class",bundle);
                startActivity(intent);
            }
        });
    }
}