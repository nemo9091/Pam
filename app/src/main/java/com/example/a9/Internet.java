package com.example.a9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;


public class Internet extends AppCompatActivity {
    button_kolor b_k=new button_kolor();
    laczenie poloncz=new laczenie();
    String error;

    String id="3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        error=getString(R.string.error);
        setContentView(R.layout.internet);
        Button odswiez = findViewById(R.id.odswiez);
        Button wylacz = findViewById(R.id.wylacz);
        Button wlacz = findViewById(R.id.wlacz);
        ImageView i;
        Bitmap bm = null;
        try {
            bm = getBitmapFromAsset("mem.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
        i = (ImageView)findViewById(R.id.imageView);
        i.setImageBitmap(bm);
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
                    Toast.makeText(Internet.this, error , Toast.LENGTH_LONG).show();
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
    private Bitmap getBitmapFromAsset(String strName) throws IOException
    {
        AssetManager assetManager = getAssets();
        InputStream istr = assetManager.open(strName);
        Bitmap bitmap = BitmapFactory.decodeStream(istr);
        return bitmap;
    }




    }




