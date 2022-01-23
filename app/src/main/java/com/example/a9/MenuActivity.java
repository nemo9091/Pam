package com.example.a9;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MenuActivity extends AppCompatActivity {
private Button button_swiatlo;
    TextView moc_menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        TextView nick =(TextView) findViewById(R.id.nick);
        moc_menu=(TextView) findViewById(R.id.moc_menu);
        Bundle show_name=getIntent().getExtras();
        if(show_name!=null) {
            String imie = show_name.getString("dane");
            nick.setText(imie);
        }

        Button swiatlo = findViewById(R.id.swiatlo);
        swiatlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNazwa = new Intent(MenuActivity.this, Swiatlo.class);
                someActivityResultLauncher.launch(intentNazwa);
            }
        });

        Button listw = findViewById(R.id.listwy);
        listw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNazwa = new Intent(MenuActivity.this, Listwy_Zasilajace.class);
                startActivity(intentNazwa);
            }
        });


        Button internet = findViewById(R.id.internet);
        internet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNazwa = new Intent(MenuActivity.this, Internet.class);
                startActivity(intentNazwa);
            }
        });


        Button brama = findViewById(R.id.brama);
        brama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNazwa = new Intent(MenuActivity.this, Brama.class);
                startActivity(intentNazwa);
            }
        });

        /*button_swiatlo=(Button) findViewById(R.id.swiatlo1);
        button_swiatlo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Toast", Toast.LENGTH_SHORT).show();
                Intent intentNazwa = new Intent(Menu.this, Swiatlo.class);
                Menu.this.startActivity(intentNazwa);

            }
        });*/







    }
/*    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                String zwrot =data.getStringExtra("zwrot");
                moc_menu.setText(""+zwrot);
            }

        }
    }*/

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data =result.getData();
                        String zwrot =data.getStringExtra("zwrot");
                        moc_menu.setText(""+zwrot);
                    }
                }
            });


}