package com.example.sharepreferece;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    CheckBox cbRemember;
    Button btnLogin;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        cbRemember = findViewById(R.id.checkBox);
        btnLogin = findViewById(R.id.button);

        sharedPreferences = getSharedPreferences("datalogin", MODE_PRIVATE);

        username.setText(sharedPreferences.getString("taikhoan", ""));
        password.setText(sharedPreferences.getString("matkhau", ""));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tk = username.getText().toString().trim();
                String mk = password.getText().toString().trim();

                if(tk.equals("Hung123") && mk.equals("12345")){
                    Toast.makeText(MainActivity.this,"Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();


                    if(cbRemember.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();

                        editor.putString("taikhoan", tk);
                        editor.putString("matkhau", mk);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    }else {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.remove("taikhoan");
                        editor.remove("matkhau");
                        editor.remove("checked");
                        editor.commit();
                    }


                }else{
                    Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });




    }
}