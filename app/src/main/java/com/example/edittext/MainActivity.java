package com.example.edittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rnd;

    TextView[] tv = new TextView[6];
    EditText et1, et2, et3;
    ImageView[] iv = new ImageView[3];
    int[] id = new int[2];
    Button[] btn = new Button[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rnd = new Random();

        tv[0] = findViewById(R.id.TV1);
        tv[1] = findViewById(R.id.TV2);
        tv[2] = findViewById(R.id.TV3);
        tv[3] = findViewById(R.id.TV4);
        tv[4] = findViewById(R.id.TV5);
        tv[5] = findViewById(R.id.TV6);

        et1 = findViewById(R.id.ET1);
        et2 = findViewById(R.id.ET2);
        et3 = findViewById(R.id.ET3);

        iv[0] = findViewById(R.id.IV1);
        iv[1] = findViewById(R.id.IV2);
        iv[2] = findViewById(R.id.IV3);

        id[0] = R.drawable.correct;
        id[1] = R.drawable.incorrect;

        btn[0] = findViewById(R.id.btn1);
        btn[1] = findViewById(R.id.btn2);
        btn[2] = findViewById(R.id.btn3);


        for(int i = 0; i < tv.length; i++){
            tv[i].setText(new String(String.valueOf(rnd.nextInt(90) + 10)));
        }

        for(int i = 0; i < iv.length;i++){
            iv[i].setVisibility(View.INVISIBLE);
        }
    }

    int counter = 0;
    public void click_btn1(View view) {
        String num1 = String.valueOf(tv[0].getText());
        String num2 = String.valueOf(tv[3].getText());
        String answer = et1.getText().toString();

        if(Integer.parseInt(num1) + Integer.parseInt(num2) == Integer.parseInt(answer)){
            iv[0].setImageResource(id[0]);
            iv[0].setVisibility(View.VISIBLE);
            counter++;
        }
        else{
            iv[0].setImageResource(id[1]);
            iv[0].setVisibility(View.VISIBLE);
        }
        btn[0].setVisibility(View.INVISIBLE);
    }

    public void click_btn2(View view) {
        String num1 = String.valueOf(tv[1].getText());
        String num2 = String.valueOf(tv[4].getText());
        String answer = et2.getText().toString();

        if(Integer.parseInt(num1) + Integer.parseInt(num2) == Integer.parseInt(answer)){
            iv[1].setImageResource(id[0]);
            iv[1].setVisibility(View.VISIBLE);
            counter++;
        }
        else{
            iv[1].setImageResource(id[1]);
            iv[1].setVisibility(View.VISIBLE);
        }
        btn[1].setVisibility(View.INVISIBLE);
    }

    public void click_btn3(View view) {
        String num1 = String.valueOf(tv[2].getText());
        String num2 = String.valueOf(tv[5].getText());
        String answer = et3.getText().toString();

        if(Integer.parseInt(num1) + Integer.parseInt(num2) == Integer.parseInt(answer)){
            iv[2].setImageResource(id[0]);
            iv[2].setVisibility(View.VISIBLE);
            counter++;
        }
        else{
            iv[2].setImageResource(id[1]);
            iv[2].setVisibility(View.VISIBLE);
        }
        btn[2].setVisibility(View.INVISIBLE);
    }

    public void click_new_btn(View view) {
        Toast.makeText(this, "your grade is: "+counter+"/3", Toast.LENGTH_LONG).show();
        for(int i = 0; i < tv.length; i++){
            tv[i].setText(new String(String.valueOf(rnd.nextInt(90) + 10)));
        }

        for(int i = 0; i < btn.length; i++){
            btn[i].setVisibility(View.VISIBLE);
        }
        et1.setText("");
        et2.setText("");
        et3.setText("");
    }
}
