package com.example.appgestionventa.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLLite extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "gestionVentas";
    private static final int DATABASE_VERSION = 1;
    String queryUsuario="CREATE TABLE IF NOT EXISTS USUARIO (idUsurio TXT PRIMARY KEY NOT NULL,nombre TXT NULL,apellidos TXT NULL, correo TXT NULL,usuario TXT NULL,contraseña TXT NULL)";
    String queryVenta="CREATE TABLE IF NOT EXISTS VENTA (idVenta TXT PRIMARY KEY NOT NULL,fecha DATE NULL,observacion TXT NULL,idUsurio TXT NOT NULL,FOREIGN KEY(idUsurio) REFERENCES USUARIO(idUsurio))";
    String queryCliente="CREATE TABLE IF NOT EXISTS CLIENTE (idCliente TXT PRIMARY KEY NOT NULL,nombre TXT NULL,correo TXT NULL,celular TXT NULL,idVenta TXT NOT NULL,FOREIGN KEY(idVenta) REFERENCES VENTA(idVenta))";
    String queryProducto="CREATE TABLE IF NOT EXISTS PRODUCTO (idProducto TEXT PRIMARY KEY  NOT NULL,nombre TEXT  NULL,stock INTEGER NULL,descripcion TEXT  NULL,precioUnitario REAL NULL,observacion TEXT  NULL)";
    String queryDetalle="CREATE TABLE IF NOT EXISTS DETALLE (idDetalle TXT PRIMARY KEY,idVenta TXT NOT NULL,idProducto TXT  NOT NULL,cantidad INT NOT NULL,descripcion TXT   NULL,precioUnitario REAL NULL,FOREIGN KEY (idVenta) REFERENCES VENTA (idVenta),FOREIGN KEY (idProducto) REFERENCES PRODUCTO (idProducto))";
    
    public SQLLite(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("queryUsuario");
        db.execSQL(queryVenta);
        db.execSQL(queryCliente);
        db.execSQL(queryProducto);
        db.execSQL(queryDetalle);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }
}
