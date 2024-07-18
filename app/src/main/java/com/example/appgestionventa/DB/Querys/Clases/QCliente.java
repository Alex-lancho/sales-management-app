package com.example.appgestionventa.DB.Querys.Clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.appgestionventa.DB.Querys.Generic.Generic;
import com.example.appgestionventa.DB.Querys.Interfaces.ICliente;
import com.example.appgestionventa.DB.SQLLite;
import com.example.appgestionventa.Modelos.Cliente;

import java.util.List;

public class QCliente extends Generic implements ICliente {
    public QCliente(Context context) {
        super(context);
    }

    @Override
    public boolean insertCliente(Cliente cliente) {
        ContentValues values = new ContentValues();
        values.put("IdCliente",cliente.getIdCliente());
        values.put("Nombre",cliente.getNombre());
        values.put("Correo",cliente.getCorreo());
        values.put("Celular",cliente.getCelular());
        values.put("IdVenta",cliente.getIdVenta());
        try {
            bd.insert("CLIENTE", null, values);
            dbHelper.close();
            return true;
        }catch (SQLiteException e){
            return false;
        }
    }

    @Override
    public List<Cliente> getAll() {
        return null;
    }

}
