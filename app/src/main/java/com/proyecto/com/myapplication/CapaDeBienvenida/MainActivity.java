package com.proyecto.com.myapplication.CapaDeBienvenida;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.proyecto.com.myapplication.R;

public class MainActivity extends AppCompatActivity {
//Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //con estas linea en res/values/styles.xml vamos a hacer pantalla completa | <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
        /* Estas dos lineas son para hacer pantalla completa, se hace a cada actividad
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN); */
        //LINEA PREDETERMINADA
        setContentView(R.layout.activity_main);
    }

    public void llamarInicio (View view){
        Intent i = new Intent(this, InicioActivity.class);
        startActivity(i);
    }
}

