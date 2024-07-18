package com.example.appgestionventa.DB.Querys.Clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;

import com.example.appgestionventa.DB.Alert;
import com.example.appgestionventa.DB.Querys.Generic.Generic;
import com.example.appgestionventa.DB.Querys.Interfaces.IVenta;
import com.example.appgestionventa.Modelos.Venta;

import java.util.List;

public class QVenta extends Generic implements IVenta {
    public QVenta(Context context){
        super(context);
    }
    String[] atributos = {
            "idVenta",
            "fecha",
            "observacion"
    };
    @Override
    public boolean insertVenta(Venta venta) {
        ContentValues values = new ContentValues();
        values.put("idVenta",venta.getIdVenta());
        values.put("fecha",venta.getFecha());
        values.put("observacion",venta.getObservacion());
        try {
            bd.insert("VENTA", null, values);

            Alert.setAlert(alertMessage[0]);
            Alert.setDescripcion("VENTA");
            return true;
        }catch (SQLiteException e){
            Alert.setAlert(alertMessage[1]);
            Alert.setDescripcion("PRODUCTO");
            return false;
        }
    }

    @Override
    public List<Venta> getAll() {
        return null;
    }

    @Override
    public Venta getVenta(String idVenta) {
        return null;
    }

    @Override
    public boolean updateVenta(Venta venta) {
        return false;
    }

    @Override
    public int amount() {
        return 0;
    }
}
