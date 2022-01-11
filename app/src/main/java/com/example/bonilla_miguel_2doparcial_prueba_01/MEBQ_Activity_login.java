package com.example.bonilla_miguel_2doparcial_prueba_01;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

public class MEBQ_Activity_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mebq_login);
    }

    public void onClickInsertar(View view){
        MEBQ_loginHelper loginHelper = new MEBQ_loginHelper(this,
                "clientesDB", null, 1);
        SQLiteDatabase sql = loginHelper.getWritableDatabase();

        String nombre = editText.getText().toString();
        String apellido = editText_Apellido.getText().toString();
        String correo = editText_Correo.getText().toString();

        sql.execSQL("INSERT INTO Clientes (Nombre, Apellido, Correo) " +
                "VALUES('" + nombre + "','" + apellido + "',''" + correo + "')");

        //Crear  una ciolleción de valores
        ContentValues values = new ContentValues();
        values.put("Nombre", nombre);
        values.put("Apellido", apellido);
        values.put("Correo", correo);

        //Enviar a la BD
        long cantidad = sql.insert("Clientes",null, values);

        //Cerrar la BD
        sql.close();

        editText_Nombre.setText(" ");
        editText_Apellido.setText(" ");
        editText_Correo.setText(" ");

        Toast.makeText(this, "Cliente insertado correctamente", Toast.LENGTH_SHORT).show();
    }
}