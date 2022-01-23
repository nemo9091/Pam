package com.example.a9;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Brama extends AppCompatActivity {
    button_kolor b_k=new button_kolor();
    laczenie poloncz=new laczenie();
    String error;

    String id="4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        error=getString(R.string.error);
        setContentView(R.layout.brama);
        Button odswiez = findViewById(R.id.odswiez);
        Button wylacz = findViewById(R.id.wylacz);
        Button wlacz = findViewById(R.id.wlacz);
        wlacz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (poloncz.polacz(id,"1").equals("true")){
                    b_k.button_zielony(wlacz,wylacz,odswiez);
                }else{
                    b_k.button_czerwony(wlacz,wylacz,odswiez);
                }

            }
        });
        wylacz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (poloncz.polacz(id,"2").equals("true")) {
                    b_k.button_czerwony(wlacz, wylacz, odswiez);
                }else{
                    Toast.makeText(Brama.this, error , Toast.LENGTH_LONG).show();
                }
            }
        });
        odswiez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String test=poloncz.polacz(id,"3");
                if (test.equals("10")) {
                    b_k.button_zielony(wlacz, wylacz, odswiez);
                }else if(test.equals("20")) {
                    b_k.button_czerwony(wlacz, wylacz, odswiez);
                }else{
                    b_k.button_zolty(wlacz, wylacz, odswiez);
                }

            }
        });


    }




}