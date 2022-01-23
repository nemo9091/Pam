package com.example.a9;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

public class button_kolor {
    public button_kolor(){
    }
    public void button_czerwony(Button button1, Button button2, Button button3){
        button1.setBackgroundColor(Color.RED);
        button1.setTextColor(Color.WHITE);
        button2.setBackgroundColor(Color.RED);
        button2.setTextColor(Color.WHITE);
        button3.setBackgroundColor(Color.RED);
        button3.setTextColor(Color.WHITE);
    }
    public void button_zielony(Button button1, Button button2, Button button3){
        button1.setBackgroundColor(Color.GREEN);
        button1.setTextColor(Color.BLACK);
        button2.setBackgroundColor(Color.GREEN);
        button2.setTextColor(Color.BLACK);
        button3.setBackgroundColor(Color.GREEN);
        button3.setTextColor(Color.BLACK);
    }
    public void button_zolty(Button button1, Button button2, Button button3){
        button1.setBackgroundColor(Color.YELLOW);
        button1.setTextColor(Color.BLACK);
        button2.setBackgroundColor(Color.YELLOW);
        button2.setTextColor(Color.BLACK);
        button3.setBackgroundColor(Color.YELLOW);
        button3.setTextColor(Color.BLACK);
    }


}
