package com.example.a9;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.net.*;
import java.io.*;

public class MainActivity extends AppCompatActivity {
    Button logowanie;
    EditText login, haslo;
    String logintest="adam";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        logowanie=findViewById(R.id.wyslij);
        logowanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String laczenie=getString(R.string.laczenie);
                Toast.makeText(MainActivity.this, laczenie , Toast.LENGTH_LONG).show();
                EditText login = findViewById(R.id.editTextTextPersonName);
                EditText haslo = findViewById(R.id.editTextTextPassword);
                String nick=login.getText().toString();
                String password=haslo.getText().toString();
                String polacz;
                laczenie poloncz=new laczenie();
                polacz=nick+";"+password;
                //if(poloncz.polacz("0",polacz).equals("true")) {
                if(nick.equals("adam")&&password.equals("123")) {
                    Intent show_name = new Intent(getApplicationContext(),MenuActivity.class);
                    show_name.putExtra("dane",login.getText().toString());
                    startActivity(show_name);
                }else {
                    startActivity(new Intent(MainActivity.this, Blad_Logowania.class));
                }

            }
        });





    }




}