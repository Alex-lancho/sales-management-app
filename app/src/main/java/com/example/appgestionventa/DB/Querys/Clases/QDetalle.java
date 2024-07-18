package com.example.appgestionventa.DB.Querys.Clases;

import android.content.Context;

import com.example.appgestionventa.DB.Querys.Generic.Generic;
import com.example.appgestionventa.DB.Querys.Interfaces.IDetalle;
import com.example.appgestionventa.Modelos.Detalle;
import com.example.appgestionventa.Modelos.Producto;

import java.util.List;

public class QDetalle extends Generic implements IDetalle {
    public QDetalle(Context context){
        super(context);
    }

    @Override
    public boolean insertProducto(Producto producto) {

        return false;
    }

    @Override
    public List<Detalle> getAll() {
        return null;
    }

    @Override
    public Detalle getProducto(String idDetalle) {
        return null;
    }

    @Override
    public boolean updateDetalle(Detalle detalle) {
        return false;
    }

    @Override
    public int amount() {
        return 0;
    }
}
