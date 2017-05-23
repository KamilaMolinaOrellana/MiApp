package com.proyecto.com.myapplication.CapaDeNegocio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.proyecto.com.myapplication.CapaDeDatos.DBHelper;
import com.proyecto.com.myapplication.R;

public class IniciarsesionActivity extends AppCompatActivity {

    EditText nombreUsuario , contrasegna , nnombre , ndireccion , nedad , ntelefono , nidioma ;
    TextView nombreCompleto, direccion, servicio, edad, telefono, idiomas;
    Button iniciarSesion , botonEliminar , botonActualizar ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarsesion);
        //BASE DE DATOS
        nombreUsuario = (EditText)findViewById(R.id.nombreUsuario);
        contrasegna = (EditText)findViewById(R.id.contrasegna);
        nombreCompleto = (TextView)findViewById(R.id.nombreCompleto);
        direccion = (TextView)findViewById(R.id.direccion);
        servicio = (TextView)findViewById(R.id.servicio);
        edad = (TextView)findViewById(R.id.edad);
        telefono = (TextView)findViewById(R.id.telefono);
        idiomas = (TextView)findViewById(R.id.idiomas);
        //PARA INICIAR SESION
        iniciarSesion = (Button)findViewById(R.id.buttonIniciarSesion);
        //PARA ELEMINIAR EL USUARIO
        botonEliminar = (Button)findViewById(R.id.buttonEliminar);

        //METODO PARA INICIAR SESION
        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(getApplicationContext(), null, null, 1);
                String buscarN = nombreUsuario.getText().toString();
                String buscarC = contrasegna.getText().toString();
                String[] informacion;
                informacion=db.buscarPorNombre(buscarN , buscarC);
                //PARA MOSTRAR LOS Y DATOS ~NOMBRE, DIRECCION, SERVICIO, EDAD, TELEFONO, IDIOMA, MENSAJE~
                nombreCompleto.setText(informacion[0]);
                direccion.setText(informacion[1]);
                //COMPLETO CON SERVICIO
                servicio.setText(informacion[2]);
                edad.setText(informacion[3]);
                telefono.setText(informacion[4]);
                idiomas.setText(informacion[5]);
                Toast.makeText(getApplicationContext(),informacion[6],Toast.LENGTH_SHORT).show();
            }
        });
        //METODO PARA ELIMINAR USUARIO
        botonEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(getApplicationContext(), null, null, 1);
                String nombre = nombreUsuario.getText().toString();
                String mensaje = db.eliminar(nombre);
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
            }
        });
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Agrego un enlace para registarse desde la parte de iniciar sesion
        final TextView registerLink = (TextView) findViewById(R.id.textDeseaRegistrarse);
        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(IniciarsesionActivity.this, RegistrarseActivity.class);
                IniciarsesionActivity.this.startActivity(registerIntent);
            }
        });
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }













}
