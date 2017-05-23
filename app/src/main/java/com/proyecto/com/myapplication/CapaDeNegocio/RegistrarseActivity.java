package com.proyecto.com.myapplication.CapaDeNegocio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.proyecto.com.myapplication.CapaDeBienvenida.InicioActivity;
import com.proyecto.com.myapplication.CapaDeDatos.DBHelper;
import com.proyecto.com.myapplication.R;

public class RegistrarseActivity extends AppCompatActivity {

    //BASE DE DATOS
    EditText EnombreCompleto, Eservicios , Edireccion , Eedad , Etelefono , Eidiomas , Econtrasegna;
    Button botonRegistrarseYa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);
        //BASE DE DATOS
        EnombreCompleto = (EditText)findViewById(R.id.nombreCompleto);
        Edireccion = (EditText)findViewById(R.id.direccion);
        Eservicios = (EditText)findViewById(R.id.servicios);
        Eedad = (EditText)findViewById(R.id.edad);
        Etelefono = (EditText)findViewById(R.id.telefono);
        Eidiomas = (EditText)findViewById(R.id.idiomas);
        Econtrasegna = (EditText)findViewById(R.id.contrasegna);
        botonRegistrarseYa = (Button)findViewById(R.id.buttonRegistrarseYa);
        botonRegistrarseYa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(getApplicationContext(),null,null,1);
                //HACER LOS DATOS OBTENIDOS ~STRINGS~
                String nombre = EnombreCompleto.getText().toString();
                String direccion = Edireccion.getText().toString();
                //SERVICIOS
                String servicios = Eservicios.getText().toString();
                String edad = Eedad.getText().toString();
                String telefono = Etelefono.getText().toString();
                String idiomas = Eidiomas.getText().toString();
                String contrasegna = Econtrasegna.getText().toString();
                //MENSAJE
                String mensaje = db.guardar(nombre, direccion, servicios, edad, telefono , idiomas , contrasegna);
                //MOSTRAR MENSAJE
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
                //PARA LIMPIAR EL CONTENIDO DE LOS DATOS AL MOMENTO DESPUES DE REGISTRARSE
                EnombreCompleto.setText("");
                Edireccion.setText("");
                Eedad.setText("");
                Etelefono.setText("");
                Eidiomas.setText("");
                Econtrasegna.setText("");
                //PARA UNA VEZ SELECCIONADO EL BOTON DE ~REGISTRARSE~ CONECTAR CON LA ACTIVIDAD ANTERIOR
                Intent registerIntent = new Intent(RegistrarseActivity.this, InicioActivity.class);
                RegistrarseActivity.this.startActivity(registerIntent);
            }
        });
    }
}
