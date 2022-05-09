package com.example.registrounivalle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
        private Button btnRegistrar;

        private Estudiante estudiante;

    String nombre;
    String apellido;
    String email;
    String celular;
    String codigo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicilizarVistas();
        etCodigo.setVisibility(View.INVISIBLE);
        swEstudiante.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                habilitarCampoEstudiante(b);
                mostrarMensaje(b);
            }
        });
        btnRegistrar.setOnClickListener(view -> {
            //validar();
            obtenerInformacionEnObjeto();
            pasarSegundaPantalla();
            pasarPantallaEnviandoObjeto();
        });

    }

    private void pasarPantallaEnviandoObjeto() {
        Intent i = new Intent(this,HomeActivity.class);
        //Crear un archivo temporal -> de tipo Bundle
        Bundle archivo = new Bundle();
        archivo.putSerializable("estudiante_objeto",estudiante);
        archivo.putString("nombre",nombre);// lo mismo que arriba, aveces se usa en internet
        i.putExtras(archivo); //Pasando de golpe todo un archivo con registros
        startActivity(i);
    }

    private void obtenerInformacionEnObjeto(){
        estudiante = new Estudiante(
                etNombre.getText().toString(),
                etApellido.getText().toString(),
                etEmail.getText().toString(),
                Integer.parseInt(etCelular.getText().toString())

        );
        if (swEstudiante.isChecked()){
            estudiante.setCodigo(Integer.parseInt(etCodigo.getText().toString()));
        }
    }
    private void pasarSegundaPantalla() {
        /*
        Para pasar o navegar entre pantallas van a utilizar el componente llamado INTENT
        deben crear una instancia de la clase denominada Intent
        como parametro al constructor de esa clase van a pasar dos valores:
        Parametro1: de donde o de que pantalla van a venir
        Parametro2: a donde o a que pantalla van a ir
        Estos parametros deben representar el contexto o ambito de las clases que representan a esas
        pantallas
        en realidad el metodo que lanzara la pantalla se llama .startActivity() pero este
        necesita que el INTENT haya resuelto el deseo del paso de pantallaas
        si esto ha pasado iran a la otra pantalla caso contrario fallará
        */
        Intent intencion = new Intent(this,HomeActivity.class);
        //Configurar paso de datos entre pantallas
        //usando un intent
        /*
        1. El intent tiene "digamos" un archivo temporar, puede entender que el archivo se llama
           EXTRAS
        2. Ese archivo contiene registros en formato CLAVE(key) -> VALOR
        3. Cada registro solo puede contener un dato en especifico
        4. El dato solo puede ser de tipo primitivo (int,etc)
        5. Cada registro entiendan que se llama EXTRA
        6.
        */
        intencion.putExtra("nombre_persona", etNombre.getText().toString());
        intencion.putExtra("apellido_persona", etApellido.getText().toString());
        /*Tambien solo se puede usar nombre ya que esta variable ya esta definida*/
        startActivity(intencion);
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
        btnRegistrar = findViewById(R.id.btnRegistrar);
    }

     private void validar() {
        nombre= etNombre.getText().toString();
        apellido= etApellido.getText().toString();
        email= etEmail.getText().toString();
        celular= etCelular.getText().toString();
        codigo= etCodigo.getText().toString();

        if (nombre.length()==0 || apellido.length()==0)
        {
            Toast.makeText(this, "Falta llenar datos", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Nombre completo: "+nombre+" "+apellido+" Email: "+email+" Celular: "+celular+" Codigo: "+codigo, Toast.LENGTH_SHORT).show();
             }
    }
}
/*
la llave es una cadena en la cual se define un valor unico para un registro
acompañado de la llave se define el valor que se va a guardar
*/