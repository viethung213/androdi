package com.example.activityforresult;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int[] listButtonID = { R.id.button2, R.id.button};
    TextView tvTop, tvBottom;
    public static final int REQUEST_CODE_TOP = 999;
    public static final int REQUEST_CODE_BOTTOM=998;
    public static final int RESULT_CODE_UPPER = 100;
    public static final int RESULT_CODE_LOWER= 101;

    ActivityResultLauncher<Intent> startActivityIntent = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new
                    ActivityResultCallback<ActivityResult>() {
                        @Override
                        public void onActivityResult(ActivityResult result) {
                            Intent intent = result.getData();

                            Log.e("ABC", String.valueOf(result.getResultCode()));
                            String title = intent.getStringExtra("yourTitle");

                            int requestCode = Integer.parseInt(intent.getStringExtra("requestCode"));

                            if(requestCode == MainActivity.REQUEST_CODE_TOP) {
                                if(result.getResultCode() == MainActivity.RESULT_CODE_UPPER)
                                    tvTop.setText(title.toUpperCase());
                                if(result.getResultCode() == MainActivity.RESULT_CODE_LOWER)
                                    tvTop.setText(title.toLowerCase());
                            }

                            if(requestCode == MainActivity.REQUEST_CODE_BOTTOM) {
                                if(result.getResultCode() == MainActivity.RESULT_CODE_UPPER)
                                    tvBottom.setText(title.toUpperCase());
                                if(result.getResultCode() == MainActivity.RESULT_CODE_LOWER)
                                    tvBottom.setText(title.toLowerCase());
                            }

                        }
                    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       init();
    }
    public  void  init(){
        tvTop=findViewById(R.id.textView);
        tvBottom=findViewById(R.id.textView2);
        for(int id:listButtonID){
            Button tmp= (Button) findViewById(id);
            tmp.setOnClickListener(this);
        }
    }

    public void showToast(String msg){
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
    }
    
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button2:
                Intent intentchangebottom = new Intent(MainActivity.this, MainActivity2.class);
                intentchangebottom.putExtra("requestCode",String.valueOf(REQUEST_CODE_BOTTOM));
                startActivityIntent.launch(intentchangebottom);
                break;
            case R.id.button:
                Intent intentchangetop = new Intent(MainActivity.this, MainActivity2.class);
                intentchangetop.putExtra("requestCode", String.valueOf(REQUEST_CODE_TOP));
                startActivityIntent.launch(intentchangetop);
                break;
        }
    }

}