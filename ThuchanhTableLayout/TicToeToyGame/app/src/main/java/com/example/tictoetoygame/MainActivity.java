package com.example.tictoetoygame;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int winer=-1;
    int startGame=0;
    Button PlayAgain,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    TextView txtShowresult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        anhxa();
        PlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(startGame==1){
                    playagain();
                    startGame=0;
                    PlayAgain.setText("BẮT ĐẦU");
                }else if(startGame==0){
                    PlayAgain.setText("CHƠI LẠI");
                    startGame=1;
                }
            }
        });
    }
    public void showToast(String msg){
        Toast.makeText(getApplicationContext(),msg, Toast.LENGTH_LONG).show();
    }

    public  void anhxa(){
        txtShowresult = (TextView) findViewById(R.id.txtShowresult);
        PlayAgain = (Button) findViewById(R.id.btPlayAgain);
        b1 = (Button) findViewById(R.id.bt1);
        b2 = (Button) findViewById(R.id.bt2);
        b3 = (Button) findViewById(R.id.bt3);
        b4 = (Button) findViewById(R.id.bt4);
        b5 = (Button) findViewById(R.id.bt5);
        b6 = (Button) findViewById(R.id.bt6);
        b7 = (Button) findViewById(R.id.bt7);
        b8 = (Button) findViewById(R.id.bt8);
        b9 = (Button) findViewById(R.id.bt9);
    }

    private void playagain() {
        Player1.clear();
        Player2.clear();
        winer=-1;
        b1.setText("");
        b1.setBackgroundColor(Color.rgb(188,185,185));
        b2.setText("");
        b2.setBackgroundColor(Color.rgb(188,185,185));
        b3.setText("");
        b3.setBackgroundColor(Color.rgb(188,185,185));
        b4.setText("");
        b4.setBackgroundColor(Color.rgb(188,185,185));
        b5.setText("");
        b5.setBackgroundColor(Color.rgb(188,185,185));
        b6.setText("");
        b6.setBackgroundColor(Color.rgb(188,185,185));
        b7.setText("");
        b7.setBackgroundColor(Color.rgb(188,185,185));
        b8.setText("");
        b8.setBackgroundColor(Color.rgb(188,185,185));
        b9.setText("");
        b9.setBackgroundColor(Color.rgb(188,185,185));
        txtShowresult.setVisibility(View.INVISIBLE);
    }
    public void btClick(View view) {
        Button button= (Button) view;
        if (winer != -1 || startGame == 0) {
            return;
        }
        int cellid=0;
        switch (button.getId()){
            case R.id.bt1:
                cellid = 1;
                break;
            case R.id.bt2:
                cellid=2;
                break;
            case R.id.bt3:
                cellid=3;
                break;
            case R.id.bt4:
                cellid=4;
                break;
            case R.id.bt5:
                cellid=5;
                break;
            case R.id.bt6:
                cellid=6;
                break;
            case R.id.bt7:
                cellid=7;
                break;
            case R.id.bt8:
                cellid=8;
                break;
            case R.id.bt9:
                cellid=9;
                break;
    }
        PlayGame(cellid,button);
}

    int ActivePlayer=1; // 1 : first, 2 second
    ArrayList<Integer> Player1 = new ArrayList<Integer>();
    ArrayList<Integer> Player2 = new ArrayList<Integer>();
    private void PlayGame(int cellid, Button button) {
        if (button.getText().toString().equals("X") || button.getText().toString().equals("O")) {
            showToast("người chơi còn lại đã chọn");
            return;
        }
        if(ActivePlayer == 1)
        {
            button.setText("X");
            button.setBackgroundColor(Color.GREEN);
            button.setTextColor(Color.RED);
            Player1.add(cellid);
            ActivePlayer = 2;
        }
        else if (ActivePlayer ==2)
        {
            button.setText("O");
            button.setTextColor(Color.WHITE);
            button.setBackgroundColor(Color.BLUE);
            Player2.add(cellid);
            ActivePlayer = 1;

        }
        CheckWiner();
        if (winer == 1) {
            txtShowresult.setVisibility(View.VISIBLE);
            txtShowresult.setText("Player 1 thắng !");

        }
        else if (winer == 2) {
            txtShowresult.setVisibility(View.VISIBLE);
            txtShowresult.setText("Player 2 thắng !");

        }
        else if (winer == 0) {
            txtShowresult.setVisibility(View.VISIBLE);
            txtShowresult.setText("Hòa !");
        }
    }

    private void CheckWiner() {
        if(Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){
            winer =1;
        }
        if(Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){
            winer =2;
        }

        if(Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){
            winer =1;
        }
        if(Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){
            winer =2;
        }

        if(Player1.contains(7) && Player1.contains(8) && Player1.contains(9)){
            winer =1;
        }
        if(Player2.contains(7) && Player2.contains(8) && Player2.contains(9)){
            winer =2;
        }

        if(Player1.contains(1) && Player1.contains(4) && Player1.contains(7)){
            winer =1;
        }
        if(Player2.contains(1) && Player2.contains(4) && Player2.contains(7)){
            winer =2;
        }

        if(Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){
            winer =1;
        }
        if(Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){
            winer =2;
        }

        if(Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){
            winer =1;
        }
        if(Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){
            winer =2;
        }

        if(Player1.contains(1) && Player1.contains(5) && Player1.contains(9)){
            winer =1;
        }
        if(Player2.contains(1) && Player2.contains(5) && Player2.contains(9)){
            winer =2;
        }

        if(Player1.contains(3) && Player1.contains(5) && Player1.contains(7)){
            winer =1;
        }
        if(Player2.contains(3) && Player2.contains(5) && Player2.contains(7)){
            winer =2;
        }
        int sum = Player1.size() + Player2.size();
        if (sum == 9 && winer == -1)
        {
            winer = 0;
        }
    }
}
