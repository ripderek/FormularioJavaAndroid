package com.example.primerejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    //crear el edittext
    private EditText txtCedula ;
    private EditText txtNombre ;
    private EditText txtCorreo ;
    private EditText txtTelefono ;
    private EditText txtCiudad ;
    private TextView txtFecha ;
    private RadioButton RdHombre ;
    private RadioButton RdMujer;
    //Para el datapicker
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //relacionar la variable del boton con el boton xd
         txtCedula = (EditText)findViewById(R.id.txtCedula);;

        txtNombre = (EditText)findViewById(R.id.txtNombres);
        txtCorreo = (EditText)findViewById(R.id.txtCorreo);
        txtTelefono = (EditText)findViewById(R.id.txtTelefono);
        txtCiudad = (EditText)findViewById(R.id.txtCiudad);
        txtFecha = (TextView)findViewById(R.id.txtFecha);
        RdHombre = (RadioButton)findViewById(R.id.rbHombre);
        //relacionar variables con los botones y textos

        //evento click del editbox
        txtFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        //Pasar la fecha al textview
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = month+"/"+dayOfMonth+"/"+year;
                txtFecha.setText(date);
            }
        };
    }

    //Metodo para ejecutar el boton enviar
    public void Enviar(View view){
        //Se crea una instancia de la actividad que se quiere abrir
        Intent i = new Intent(this, MainActivity2.class);
        String Genero = RdHombre.isChecked()?"Hombre":"Mujer";
        //se envia el dato a la siguiente actividad
        i.putExtra("cedula",txtCedula.getText().toString());
        i.putExtra("nombres",txtNombre.getText().toString());
        i.putExtra("correo",txtCorreo.getText().toString());
        i.putExtra("telefono",txtTelefono.getText().toString());
        i.putExtra("ciudad",txtCiudad.getText().toString());
        i.putExtra("Fecha",txtFecha.getText().toString());
        i.putExtra("genero",Genero);
        if(Verficiar()) startActivity(i);
        else {
            Toast.makeText(this, "Llene el formulario por favor", Toast.LENGTH_SHORT).show();
        }

        //se inicia la actividad
    }
    public void Limpiar(View view){
        txtCedula = (EditText)findViewById(R.id.txtCedula);;
        txtNombre = (EditText)findViewById(R.id.txtNombres);
        txtCorreo = (EditText)findViewById(R.id.txtCorreo);
        txtTelefono = (EditText)findViewById(R.id.txtTelefono);
        txtCiudad = (EditText)findViewById(R.id.txtCiudad);
        txtFecha = (TextView)findViewById(R.id.txtFecha);
        RdMujer = (RadioButton)findViewById(R.id.rbMujer);
        txtCedula.setText("");
        txtNombre.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtCiudad.setText("");
        txtFecha.setText("");
        RdHombre.setChecked(false);
        RdMujer.setChecked(false);
    }
    public boolean Verficiar(){
        txtCedula = (EditText)findViewById(R.id.txtCedula);;
        txtNombre = (EditText)findViewById(R.id.txtNombres);
        txtCorreo = (EditText)findViewById(R.id.txtCorreo);
        txtTelefono = (EditText)findViewById(R.id.txtTelefono);
        txtCiudad = (EditText)findViewById(R.id.txtCiudad);
        txtFecha = (TextView)findViewById(R.id.txtFecha);
        RdMujer = (RadioButton)findViewById(R.id.rbMujer);
        RdHombre = (RadioButton)findViewById(R.id.rbHombre);

        if(txtCedula.getText().toString().trim().length() == 0) return false;
        if(txtNombre.getText().toString().trim().length() == 0) return false;
        if(txtCorreo.getText().toString().trim().length() == 0) return false;
        if(txtTelefono.getText().toString().trim().length() == 0) return false;
        if(txtCiudad.getText().toString().trim().length() == 0) return false;
        if(txtFecha.getText().toString().trim().length() == 0) return false;

        Boolean retonra = RdMujer.isChecked()?true:RdHombre.isChecked()?true:false;
        return retonra;
    }
}