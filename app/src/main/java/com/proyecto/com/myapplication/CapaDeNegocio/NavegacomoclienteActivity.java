package com.proyecto.com.myapplication.CapaDeNegocio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.proyecto.com.myapplication.CapaDeDatos.MapsActivity;
import com.proyecto.com.myapplication.R;

public class NavegacomoclienteActivity extends AppCompatActivity {

    private Button buttonIrmapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegacomocliente);
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //estas lineas son para concatenar con la vista del mapa
        buttonIrmapa = (Button)findViewById(R.id.buttonIrmapa);
        buttonIrmapa.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                Intent intent = new Intent(NavegacomoclienteActivity.this,MapsActivity.class);
                startActivity(intent);
            }
        });
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }
}
