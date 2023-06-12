package com.example.primerejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //crear el edittext
    private EditText txtCedula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //relacionar la variable del boton con el boton xd
        txtCedula = (EditText)findViewById(R.id.txtCedula);
    }

    //Metodo para ejecutar el boton enviar
    public void Enviar(View view){
        //Se crea una instancia de la actividad que se quiere abrir
        Intent i = new Intent(this, MainActivity2.class);
        //se envia el dato a la siguiente actividad
        i.putExtra("cedula",txtCedula.getText().toString());
        //se inicia la actividad
        startActivity(i);
    }
}