package com.example.registrounivalle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    //Atributos que representen a sus vistas
   // private TextView txtResultado;
    //variables generales de la clase
    String nombre, apellido;

    private TextView txtResultado;
    private Estudiante estudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarVistas();
        obtenerDatosPrimeraPantalla();
        //mostrarDatos();
        mostrarDatosDesdeObjeto();
    }

    private void mostrarDatosDesdeObjeto() {
        // getSerializable devuelve un objeto Generico no particular
        // tu quieres un objeto en particular de tipo estudiante
        //en estos casos generalmente en java un casteo ayuda a solamente extraer
        //de este objeto general lo que a ti te importa
        estudiante = (Estudiante) this.getIntent().getExtras().getSerializable("estudiante_objeto");
        txtResultado.setText(estudiante.toString());
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