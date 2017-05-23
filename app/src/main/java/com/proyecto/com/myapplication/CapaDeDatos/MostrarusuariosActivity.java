package com.proyecto.com.myapplication.CapaDeDatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.proyecto.com.myapplication.CapaDeDatos.DBHelper;
import com.proyecto.com.myapplication.R;

import java.util.ArrayList;

public class MostrarusuariosActivity extends AppCompatActivity {

    ListView lv ;
    ArrayList<String> lista;
    ArrayAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrarusuarios);
        //PARA MOSTRAR CON LA BASE DE DATOS
        lv = (ListView)findViewById(R.id.lista);
        DBHelper db = new DBHelper(getApplicationContext(),null,null,1);
        lista = db.llenar_lv();
        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lista);
        lv.setAdapter(adaptador);
    }
}
