package com.example.demolistviewnangcao;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvcity;
    ArrayList<city> cityArrayList = new ArrayList<>();
    CityAdapter cityAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lvcity= findViewById(R.id.lvCity);
        cityArrayList.add(new city("New York",R.drawable.newyork,"http://1.com"));
        cityArrayList.add(new city("Paris",R.drawable.paris,"http://2.com"));
        cityArrayList.add(new city("Rome",R.drawable.rome,"http://3.com"));
        cityAdapter = new CityAdapter(this,R.layout.dong_thanh_pho,cityArrayList);
        lvcity.setAdapter(cityAdapter);

        lvcity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"deleted "+cityArrayList.get(position).getNameCity(),Toast.LENGTH_LONG).show();
                cityArrayList.remove(position);
                cityAdapter.notifyDataSetChanged();
            }
        });
    }
}