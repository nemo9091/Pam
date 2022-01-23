package com.example.a9;

import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.*;
import java.io.*;



import androidx.appcompat.app.AppCompatActivity;



public class laczenie{


    public laczenie() {
    }

    public String polacz(String id,String dane){

    Socket logowanie = null;
    try {
        Socket sprawdz_stan = new Socket("192.168.1.1",9999);
        PrintWriter wyslij = new PrintWriter(sprawdz_stan.getOutputStream());
        wyslij.println(id+";"+dane);
        wyslij.flush();
        InputStreamReader otrzymane =new InputStreamReader(sprawdz_stan.getInputStream());
        BufferedReader pamiec=new BufferedReader(otrzymane);
        String str=pamiec.readLine();
        return str;
    } catch (IOException e) {
        return "0";
    }




}


}
