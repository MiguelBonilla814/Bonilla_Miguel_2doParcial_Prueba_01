package com.example.bonilla_miguel_2doparcial_prueba_01;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MEBQ_loginDAL {
    private MEBQ_loginHelper loginHelper;
    private SQLiteDatabase sql;
    private Context context;

    public MEBQ_loginDAL(Context context) {
        this.context = context;
    }

    public void open(){
        MEBQ_loginHelper clientesHelper = new MEBQ_loginHelper(context, "clientesDB", null, 1);
        sql = clientesHelper.getWritableDatabase();
    }

    public long insert (MEBQ_Usuario usuario){
        long count = 0;
        try{
            this.open();
            ContentValues values = new ContentValues();

            values.put("Usuario",usuario.getUsuario());
            values.put("Contrasenia", usuario.getContrasenia());

            count = sql.insert("Clientes", null, values);
        }
        catch (Exception e){
            throw e;
        }
        finally {
            sql.close();
        }
        return count;
    }

    public MEBQ_Usuario selectByCodigo(String ingreso_usuario, String contrasenia){
        MEBQ_Usuario usuario = null;
        try{
            String select = "SELECT Nombre, Apellido, Correo " +
                    "FROM Usuario " +
                    "WHERE Usuario = " + ingreso_usuario +
                    "AND Contrasenia = " + contrasenia;

            Cursor cursor = sql.rawQuery(select, null);

            if(cursor.moveToFirst()){
                usuario.setUsuario(cursor.getString(0));
                usuario.setContrasenia(cursor.getString(1));
            }
            else{

            }
        }
        catch (Exception e){
            throw e;
        }
        finally {
            sql.close();
        }
        return usuario;
    }
}
