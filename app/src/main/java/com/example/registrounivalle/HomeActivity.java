package com.example.registrounivalle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    //Atributos que representen a sus vistas
    private TextView txtResultado;
    //variables generales de la clase
    String nombre, apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarVistas();
        obtenerDatosPrimeraPantalla();
        mostrarDatos();
    }

    private void mostrarDatos() {
        txtResultado.setText(nombre + ", "+ apellido);
    }

    private void obtenerDatosPrimeraPantalla() {
        nombre = this.getIntent().getExtras().getString("nombre_persona","");
        apellido= this.getIntent().getExtras().getString("apellido_persona","");
    }

    private void inicializarVistas() {
        txtResultado = findViewById(R.id.txtResultado);
    }
}