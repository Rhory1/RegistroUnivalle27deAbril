package com.example.registrounivalle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeActivity extends AppCompatActivity {
    //Atributos que representen a sus vistas
   // private TextView txtResultado;
    //variables generales de la clase
    String nombre, apellido;

    ArrayList<String> opciones;


    private TextView txtResultado;
    private TextView txtFaltas;
    private Spinner spOpciones;
    private Button btnCalcular;
    private Estudiante estudiante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        inicializarVistas();
        obtenerDatosPrimeraPantalla();
        //mostrarDatos();
        mostrarDatosDesdeObjeto();
        cargarDatosSpinner();
        btnCalcular.setOnClickListener(view -> {
            procesarDatosSpinner();
        });
    }

    private void procesarDatosSpinner() {
        int solucion;
        int x=0;
        int y=0;
        //obtener la poscion del spinner
        //1: su valor en formato de un string
        String valor =  spOpciones.getSelectedItem().toString();
        // String valor = (String) spOciones.getSelectedItem();
        //2: su posicion en el spinner, salvo hagan algo muy extraño
        //esa posicion coinside con lo que seria el indice de su arreglo o lista
        int posicion = spOpciones.getSelectedItemPosition();
                //Posicion de la lista que se observa
        switch (posicion){
            case 0:
                break;
            case 1:

                 int indice = (int)(Math.random()*10);
                 for (int j=0;j<indice;j++){
                     for (int i = 1; i<10; i++) {
                if (i == 1 || i == 2) {
                    txtFaltas.setText("1");
                    x = 1;
                    y = 1;
                } else {
                    solucion = x + y;
                    txtFaltas.setText(solucion);
                }
            }
                }

                 break;
            default:txtFaltas.setText("10");

            }


    }


    private void cargarDatosSpinner() {
        obtenerFuenteDeDatos();
        /*
        * Para cargar datos a su Spinner, donde cada elemento u opcion se conoce como ITEM
        * necesita un adaptador -> un transformador que convierte una fuente de datos
        * que convierte en elementos visuales.
        * es como un puente donde el extremo inicial es la estructura de datos con su informacion
        * y el otro lado del puente es el componente visual del SPINNER que recibe sus datos
        * convertidos en vistas
        * --------
        * 1.- hay adaptadores por defeto ya diseñados y hay adaptadores que tienen que configurar
        * desde 0 cero
        * 2.- por cada elelmento de su ARRAY se genera una vista gracial al adater.Array =>
        * Adaptador genera 10 vistas.
        * */
        //El adaptador fabricado mas simple que hay es Array adapter
        // Array adapter necesita algunos parametros de configuracionn para funcionar y realizar el
        // proceso de transformacio
        /*
        * 1: Contexto de la pantalla donde se van a dibujar estos elementos visuales
        * 2: es la referencia al componente visual o layaut que sea diseñado que usara para dibujar
        * que diseño quieres que se dibuje con cada elemento de tu ARRAY
        cada intem o elemento
        * 3: estructura que continen la fuente de datos*/

         /*Cuando se usa la pala android antes de R se refiere a recursos predeterminados en android */
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,opciones);
        //El spinner necesita un adaptador para que este le diga cuantas vistas va a acoplar a su escritura
        spOpciones.setAdapter(adaptador);
    }
//poner sus datos en una estructura amigable en el lenguaje
    private void obtenerFuenteDeDatos() {
        opciones = new ArrayList<>(Arrays.asList("Seleccione la opcion","Notas", "Faltas"));
        // agregar un elemento a ala lista usan .add
        // quizas seria la opcion en un bucle que este recorriendo todos los registros de la consulta
        opciones.add("Mejor opcion");

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
        spOpciones = findViewById(R.id.spOpciones);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtFaltas = findViewById(R.id.txtFaltas);
    }
}