package com.example.registrounivalle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
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
        private String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicilizarVistas();
        btnRegistra.setOnClickListener(view -> validar());
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
            Toast.makeText(this, "Faltan llegar datos", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Nombre completo: "+nombre+apellido+" Email: "+email+" Celular: "+celular+" Codigo: "+codigo, Toast.LENGTH_SHORT).show();
        }
    }
}