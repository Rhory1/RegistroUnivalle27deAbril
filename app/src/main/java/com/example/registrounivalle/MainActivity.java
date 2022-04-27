package com.example.registrounivalle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        private EditText etNombre;
        private EditText etApellido;
        private EditText etEmail;
        private EditText etCelular;
        private Switch swEstudiante;
        private EditText etCodigo;
        private Button btnRegistra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicilizarVistas();
        //Visibilidad del elemento o view en pantalla y espera un valor ese valor ya lo tienen
        // preparado en constantes en las librerias
        etCodigo.setVisibility(View.INVISIBLE);
        //Para un switch o checbox pueden configurar un listener para que este pendiente a los cambios
        //en este componente cambio = marcado o no marcado
        swEstudiante.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                habilitarCampoEstudiante(b);
                mostrarMensaje(b);
            }
        });
        btnRegistra.setOnClickListener(view -> validar());
    }

    private void habilitarCampoEstudiante(boolean marcado) {
        if (marcado ){
            etCodigo.setVisibility(View.VISIBLE);
        }else{
            etCodigo.setVisibility(View.GONE);
        }

    }

    private void mostrarMensaje(boolean marcado) {
        String mensaje = "no estoy marcado";
        if(marcado){
            mensaje = "Estoy marcado";
        }
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }

    private void inicilizarVistas() {
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etEmail = findViewById(R.id.etEmail);
        etCelular = findViewById(R.id.etCelular);
        swEstudiante = findViewById(R.id.swEstudiante);
        etCodigo = findViewById(R.id.etCodigo);
        btnRegistra = findViewById(R.id.btnRegistra);
    }
    private void validar() {
        String nombre= etNombre.getText().toString();
        String apellido= etApellido.getText().toString();
        String email= etEmail.getText().toString();
        String celular= etCelular.getText().toString();
        String codigo= etCodigo.getText().toString();

        if (nombre.length()==0 || apellido.length()==0)
        {
            Toast.makeText(this, "Falta llenar datos", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Nombre completo: "+nombre+" "+apellido+" Email: "+email+" Celular: "+celular+" Codigo: "+codigo, Toast.LENGTH_SHORT).show();
        }
    }
}