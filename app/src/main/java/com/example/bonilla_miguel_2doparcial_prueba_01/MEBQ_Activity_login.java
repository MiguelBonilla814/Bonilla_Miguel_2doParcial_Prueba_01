package com.example.bonilla_miguel_2doparcial_prueba_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MEBQ_Activity_login extends AppCompatActivity {

    private EditText editText_usuario;
    private EditText editText_contrasenia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mebq_login);
        editText_contrasenia = findViewById(R.id.editTextText_contraseña);
        editText_usuario = findViewById(R.id.editTextText_usuario);
    }

    public void onClickInsertar(View view){
        MEBQ_loginHelper loginHelper = new MEBQ_loginHelper(this,
                "clientesDB", null, 1);
        SQLiteDatabase sql = loginHelper.getWritableDatabase();

        String usuario = editText_usuario.getText().toString();
        String contrasenia = editText_contrasenia.getText().toString();

        /*sql.execSQL("INSERT INTO Usuario (Usuario, Contrasenia) " +
                "VALUES('" + usuario + "','" + contrasenia + "')");*/

        //Crear  una ciolleción de valores
        ContentValues values = new ContentValues();
        values.put("Usuario", usuario);
        values.put("Contrasenia", contrasenia);

        //Enviar a la BD
        long cantidad = sql.insert("Usuario",null, values);

        //Cerrar la BD
        sql.close();

        editText_usuario.setText(" ");
        editText_contrasenia.setText(" ");

        Toast.makeText(this, "Cliente insertado correctamente", Toast.LENGTH_SHORT).show();
    }

    public void onClickIngresar(View view) {
        String usuario = "Miguel";
        String contrasenia = "1234";
        if(usuario.equals(editText_usuario.getText().toString())
                && contrasenia.equals(editText_contrasenia.getText().toString())){
            Intent intent = new Intent(this, MEBQ_Activity_confirmacion.class);
            startActivity(intent);
        }
    }
}