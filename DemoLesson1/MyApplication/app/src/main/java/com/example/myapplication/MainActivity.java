package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnclickme;
    EditText edname;
    TextView txtshowname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnclickme=findViewById(R.id.btnclickme);
        edname=findViewById(R.id.edname);
        txtshowname=findViewById(R.id.txtshowtext);
        btnclickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=edname.getText().toString();
                txtshowname.setText("WELCOME: "+name);

            }
        });


    }


}
