package com.example.a9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Swiatlo extends AppCompatActivity {
    button_kolor b_k=new button_kolor();
    laczenie poloncz=new laczenie();
    String error;
    private TextView moc;

    String id="1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("swiatlo");
        error=getString(R.string.error);
        setContentView(R.layout.swiatlo);
        Button odswiez = findViewById(R.id.odswiez);
        Button wylacz = findViewById(R.id.wylacz);
        Button wlacz = findViewById(R.id.wlacz);
        Button wyslij = findViewById(R.id.wyslij);
        EditText moc= (EditText) findViewById(R.id.moc_inpot);

        wyslij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent zwrot =new Intent();
                zwrot.putExtra("zwrot", moc.getText().toString());
                setResult(RESULT_OK, zwrot);
                finish();
            }
        });
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
                    Toast.makeText(Swiatlo.this, error , Toast.LENGTH_LONG).show();
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