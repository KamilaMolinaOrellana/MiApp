package com.proyecto.com.myapplication.CapaDeBienvenida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.proyecto.com.myapplication.CapaDeDatos.MostrarusuariosActivity;
import com.proyecto.com.myapplication.CapaDeNegocio.IniciarsesionActivity;
import com.proyecto.com.myapplication.CapaDeNegocio.NavegacomoclienteActivity;
import com.proyecto.com.myapplication.CapaDeNegocio.RegistrarseActivity;
import com.proyecto.com.myapplication.R;

public class InicioActivity extends AppCompatActivity {

    //BASE DE DTOS
    Button botonLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        //PARA MOSTRAR UNA LISTA DE LOS USURAIOS
        botonLista = (Button)findViewById(R.id.buttonLista);
        botonLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(getApplicationContext(),MostrarusuariosActivity.class);
                startActivity(intento);
            }
        });
    }
//Aquí se llaman las otras actividades por medio de los botones
    public void llamarIniciarsesion (View view){
        Intent i = new Intent(this, IniciarsesionActivity.class);
        startActivity(i);
    }
    public void llamarRegistrarse (View view){
        Intent i = new Intent(this, RegistrarseActivity.class);
        startActivity(i);
    }
    public void llamarNavegacomocliente (View view){
        Intent i = new Intent(this, NavegacomoclienteActivity.class);
        startActivity(i);
    }
}

