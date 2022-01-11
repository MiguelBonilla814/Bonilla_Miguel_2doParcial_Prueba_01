package com.example.bonilla_miguel_2doparcial_prueba_01;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MEBQ_loginHelper extends SQLiteOpenHelper {

    String createTable_Usuario = "CREATE TABLE USUARIO " +
            "(Codigo INTEGER PRIMARY KEY AUTOINCREMENT," +
            "Usuario TEXT, Contrasenia TEXT)";

    public MEBQ_loginHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable_Usuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Usuario");

        db.execSQL(createTable_Usuario);
    }
}
