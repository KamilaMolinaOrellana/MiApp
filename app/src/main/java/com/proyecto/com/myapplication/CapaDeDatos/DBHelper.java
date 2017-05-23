package com.proyecto.com.myapplication.CapaDeDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    //NOMBRE DE LA TABLA
    public static final String TABLE_NAME = "usuarios";
    //NOMBRES DE LOS CAMPOS
    public static final String CN_NAME = "nombre";
    public static final String CN_DIRECCION = "direccion";
    public static final String CN_TELEFONO = "telefono";
    public static final String CN_EDAD = "edad";
    public static final String CN_IDIOMA = "idiomas";
    public static final String CN_CONTRASEGNA = "contrasegna";
    public static final String CN_SERVICIO = "servicio";

    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ "(" + CN_NAME + " text not null, " + CN_DIRECCION +
            " text not null, " + CN_SERVICIO + " text not null , " + CN_EDAD + " text not null, " + CN_TELEFONO +
            " text not null, " + CN_IDIOMA + " text not null, " + CN_CONTRASEGNA + " text not null)";

    private static final String DB_NAME = "datosBaseDatos";
    private static final int DB_SCHEME_VERSION = 1;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //SI NO EXISTE LA BASE DE DATOS LA CREA Y EJECUTA LOS SIG. COMANDOS
        db.execSQL(CREATE_TABLE);
        guardarUsuarios(db);

    }

    private void guardarUsuarios(SQLiteDatabase database){
            ContentValues values = new ContentValues();
        values.put(DBHelper.CN_NAME, "Kamila Molina Orellana");
        values.put(DBHelper.CN_DIRECCION, "Estévez de Toral y Boívar");
        values.put(CN_SERVICIO, "Guia turistica. Interprete");
        values.put(DBHelper.CN_EDAD, "20");
        values.put(DBHelper.CN_TELEFONO, "0988772894");
        values.put(DBHelper.CN_IDIOMA, "Español. Inglés");
        values.put(DBHelper.CN_CONTRASEGNA, "123456");
        database.insert(TABLE_NAME , null , values);
        //guardar("Kamila Molina Orellana", "Estévez de Toral y Boívar",
        // "Guia turistica. Interprete","20", "0988772894", "Español, Inglés", "123456");
            values = new ContentValues();
        values.put(DBHelper.CN_NAME, "Juan Jose Bedoya");
        values.put(DBHelper.CN_DIRECCION, "Calle del Tejar");
        values.put(CN_SERVICIO, "Transporte");
        values.put(DBHelper.CN_EDAD, "22");
        values.put(DBHelper.CN_TELEFONO, "0984742633");
        values.put(DBHelper.CN_IDIOMA, "Español");
        values.put(DBHelper.CN_CONTRASEGNA, "1234");
        database.insert(TABLE_NAME , null , values);
        //guardar("Juan Jose Bedoya", "Calle del Tejar", "Transporte",
        // "22", "0987742633", "Español", "1234");
            values = new ContentValues();
        values.put(DBHelper.CN_NAME, "Maria Jose Altamirano");
        values.put(DBHelper.CN_DIRECCION, "Hermano Miguel y Gran Colombia");
        values.put(CN_SERVICIO, "Interprete");
        values.put(DBHelper.CN_EDAD, "25");
        values.put(DBHelper.CN_TELEFONO, "0994720444");
        values.put(DBHelper.CN_IDIOMA, "Español. Ingles. Frances.");
        values.put(DBHelper.CN_CONTRASEGNA, "12345");
        database.insert(TABLE_NAME , null , values);
        //guardar("Maria Jose Altamirano", "Hermano Miguel y Gran Colombia",
        //"Interprete","25", "0994720444","Español. Ingles. Frances.", "12345");
            values = new ContentValues();
        values.put(DBHelper.CN_NAME, "Mirian Orellana Vimos");
        values.put(DBHelper.CN_DIRECCION, "Calle Larga y Tarqui");
        values.put(CN_SERVICIO, "Guia Turistica");
        values.put(DBHelper.CN_EDAD, "52");
        values.put(DBHelper.CN_TELEFONO, "0993931775");
        values.put(DBHelper.CN_IDIOMA, "Español");
        values.put(DBHelper.CN_CONTRASEGNA, "123456");
        database.insert(TABLE_NAME , null , values);
            values = new ContentValues();
        values.put(DBHelper.CN_NAME, "Edgar Molina Alvarado");
        values.put(DBHelper.CN_DIRECCION, "Machalilla Y Rio Paute");
        values.put(CN_SERVICIO, "Guia Turistica. Transporte");
        values.put(DBHelper.CN_EDAD, "55");
        values.put(DBHelper.CN_TELEFONO, "0993931773");
        values.put(DBHelper.CN_IDIOMA, "Español");
        values.put(DBHelper.CN_CONTRASEGNA, "12345");
        database.insert(TABLE_NAME , null , values);
            values = new ContentValues();
        values.put(DBHelper.CN_NAME, "Karla Peralta Ordonez");
        values.put(DBHelper.CN_DIRECCION, "Calle Vieja Y De Las Alcabalas");
        values.put(CN_SERVICIO, "Interprete");
        values.put(DBHelper.CN_EDAD, "20");
        values.put(DBHelper.CN_TELEFONO, "099269758");
        values.put(DBHelper.CN_IDIOMA, "Español. Ingles. Italiano");
        values.put(DBHelper.CN_CONTRASEGNA, "12345");
        database.insert(TABLE_NAME , null , values);
            values = new ContentValues();
        values.put(DBHelper.CN_NAME, "Mateo Carpio Espinoza");
        values.put(DBHelper.CN_DIRECCION, "Miguel Velez Y Mariscal Lamar");
        values.put(CN_SERVICIO, "Guia Turistica. Transporte. Interprete");
        values.put(DBHelper.CN_EDAD, "30");
        values.put(DBHelper.CN_TELEFONO, "0919357428");
        values.put(DBHelper.CN_IDIOMA, "Español. Ingles. Mandarin. Frnaces");
        values.put(DBHelper.CN_CONTRASEGNA, "12345");
        database.insert(TABLE_NAME , null , values);
            values = new ContentValues();
        values.put(DBHelper.CN_NAME, "Sandra Correa Esmeraldas");
        values.put(DBHelper.CN_DIRECCION, "Francisco Cisneros Y Daniel Fernandez De Cordova");
        values.put(CN_SERVICIO, "Guia Turistica.");
        values.put(DBHelper.CN_EDAD, "40");
        values.put(DBHelper.CN_TELEFONO, "0863219826");
        values.put(DBHelper.CN_IDIOMA, "Español. Ingles");
        values.put(DBHelper.CN_CONTRASEGNA, "12345");
        database.insert(TABLE_NAME , null , values);
            values = new ContentValues();
        values.put(DBHelper.CN_NAME, "Estuardo Zambrano Ortega");
        values.put(DBHelper.CN_DIRECCION, "Vargas Machuca y Honorato Vasquez");
        values.put(CN_SERVICIO, "Transporte");
        values.put(DBHelper.CN_EDAD, "21");
        values.put(DBHelper.CN_TELEFONO, "0934859603");
        values.put(DBHelper.CN_IDIOMA, "Español");
        values.put(DBHelper.CN_CONTRASEGNA, "1234567");
        database.insert(TABLE_NAME , null , values);
            values = new ContentValues();
        values.put(DBHelper.CN_NAME, "Micaela Chalco Perez");
        values.put(DBHelper.CN_DIRECCION, "Avenida Jose Peralta Y Alfonso Cordero");
        values.put(CN_SERVICIO, "Transporte");
        values.put(DBHelper.CN_EDAD, "20");
        values.put(DBHelper.CN_TELEFONO, "099068429");
        values.put(DBHelper.CN_IDIOMA, "Español. Frances");
        values.put(DBHelper.CN_CONTRASEGNA, "1234567");
        database.insert(TABLE_NAME , null , values);
            values = new ContentValues();
        values.put(DBHelper.CN_NAME, "Francisco Zeas Moscoso");
        values.put(DBHelper.CN_DIRECCION, "Avenida Don Bosco y Santa Maria");
        values.put(CN_SERVICIO, "Interprete");
        values.put(DBHelper.CN_EDAD, "35");
        values.put(DBHelper.CN_TELEFONO, "0985264759");
        values.put(DBHelper.CN_IDIOMA, "Español. Mandarin. Ingles");
        values.put(DBHelper.CN_CONTRASEGNA, "12345678");
        database.insert(TABLE_NAME , null , values);
            values = new ContentValues();
        values.put(DBHelper.CN_NAME, "Juan Carrasco Vega");
        values.put(DBHelper.CN_DIRECCION, "Camilo Ponce Y Avenida Paseo De Los Canaris");
        values.put(CN_SERVICIO, "Transporte");
        values.put(DBHelper.CN_EDAD, "21");
        values.put(DBHelper.CN_TELEFONO, "0934925762");
        values.put(DBHelper.CN_IDIOMA, "Español. Ingles");
        values.put(DBHelper.CN_CONTRASEGNA, "1234");
        database.insert(TABLE_NAME , null , values);
            values = new ContentValues();
        values.put(DBHelper.CN_NAME, "Pedro Jimenez Coral");
        values.put(DBHelper.CN_DIRECCION, "Presidente Cordova Y Marisal Sucre");
        values.put(CN_SERVICIO, "Guia Turistica");
        values.put(DBHelper.CN_EDAD, "50");
        values.put(DBHelper.CN_TELEFONO, "0991290430");
        values.put(DBHelper.CN_IDIOMA, "Español. Ingles");
        values.put(DBHelper.CN_CONTRASEGNA, "2345");
        database.insert(TABLE_NAME , null , values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //SE ELIMINA LA VERSION DE BD ANTERIOR
        //db.execSQL("DROP TABLE IF EXISTS Cliente");
        //db.execSQL(sql);
    }

    public String guardar (String nombre ,String direccion , String servicios ,
                           String edad , String telefono , String idiomas , String contrasegna){
        String mensaje ="";
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contenedor = new ContentValues();
        contenedor.put(CN_NAME,nombre);
        contenedor.put(CN_DIRECCION, direccion);
        contenedor.put(CN_SERVICIO, servicios);
        contenedor.put(CN_EDAD, edad);
        contenedor.put(CN_TELEFONO, telefono);
        contenedor.put(CN_IDIOMA, idiomas);
        contenedor.put(CN_CONTRASEGNA, contrasegna);
        try{
            database.insertOrThrow(TABLE_NAME,null,contenedor);
            mensaje = "USUARIO REGISTRADO CORRECTAMENTE";
        }catch (SQLException e){
            mensaje = "NO REGISTRADO\n\nVUELVA A INGRESAR LOS DATOS";
        }
        return mensaje;
    }

    public String[] buscarPorNombre (String buscarN , String buscarC){
        String[] informacion = new String [7];
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM " + TABLE_NAME + " WHERE " + CN_NAME + " ='"
                + buscarN + "' AND " +CN_CONTRASEGNA+ "='"+buscarC+"'";
        Cursor registros = database.rawQuery(q, null);
        if(registros.moveToFirst()){
            for(int i=0 ; i<6 ; i++){
                informacion[i]= registros.getString(i);
            }
            informacion[6]= "USUARIO ENCONTRADO EXITOSAMENTE\nSIGA HACIA ABAJO";
        }else{
            informacion[6]= "REVICE NOMBRE O CONTRASEAÑA\nINTENTE NUEVAMENTE";
        }
        database.close();
        return informacion;
    }


    public String eliminar(String Nombre){
        String mensaje ="";
        SQLiteDatabase database = this.getWritableDatabase();
        int cantidad = database.delete(TABLE_NAME, CN_NAME+"='" + Nombre + "'", null);
        if (cantidad !=0){
            mensaje="USUARIO ELIMINADO";
        }
        else{
            mensaje = "~NO EXISTE EL USUARIO~\nNO SE PUEDE ELIMINAR";
        }
        database.close();
        return mensaje;
    }

    //PARA RETORNAR LOS USUARIOS
    public ArrayList llenar_lv(){
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM " + TABLE_NAME;
        Cursor registros = database.rawQuery(q,null);
        if(registros.moveToFirst()){
            do{
                lista.add("\t**********\nNombre: " + registros.getString(0) +
                        "\nDirección: "+ registros.getString(1) + "\n" +
                        "Servicio(s): "+ registros.getString(2) +
                        "\nEdad: "+ registros.getString(3) + " años\n" +
                        "Telefono: "+ registros.getString(4) +
                        "\nIdioma(s): "+ registros.getString(5) + "\n");
            }while(registros.moveToNext());
        }
        return lista;

    }
}