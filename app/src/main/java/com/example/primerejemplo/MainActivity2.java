package com.example.primerejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    //crear una instacia del textview con el mismo id
    private TextView lblCedula;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //se crea la relacion de la instacia con el textview
        lblCedula = (TextView)findViewById(R.id.lblCedula);

        String dato = getIntent().getStringExtra("cedula");
        lblCedula.setText("cedula: " + dato);
    }
}