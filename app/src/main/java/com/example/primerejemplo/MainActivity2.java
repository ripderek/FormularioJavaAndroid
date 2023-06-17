package com.example.primerejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    //crear una instacia del textview con el mismo id
    private TextView lblCedula;
    private TextView lblNombres;
    private TextView lblCorreo;
    private TextView lblTelonfo;
    private TextView lblCiudad;
    private TextView lblFecha;
    private TextView lblGenero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //se crea la relacion de la instacia con el textview
        lblCedula = (TextView)findViewById(R.id.lblCedula);
        lblNombres = (TextView)findViewById(R.id.lblNombres);
        lblCorreo = (TextView)findViewById(R.id.lblCorreo);
        lblTelonfo = (TextView)findViewById(R.id.lblTelefono);
        lblCiudad = (TextView)findViewById(R.id.lblCiudad);
        lblFecha = (TextView)findViewById(R.id.lblFecha);
        lblGenero = (TextView)findViewById(R.id.lblGenero);

        lblCedula.setText("Cedula : " + getIntent().getStringExtra("cedula"));
        lblNombres.setText("Nombres : " + getIntent().getStringExtra("nombres"));
        lblCorreo.setText("Correo : " + getIntent().getStringExtra("correo"));
        lblTelonfo.setText("Telefono : " + getIntent().getStringExtra("telefono"));
        lblCiudad.setText("Ciudad : " + getIntent().getStringExtra("ciudad"));
        lblFecha.setText("Fecha : " + getIntent().getStringExtra("Fecha"));
        lblGenero.setText("Genero : " + getIntent().getStringExtra("genero"));


    }
}