package com.example.appgestionventa.DB.Querys.Interfaces;

import android.database.Cursor;

import com.example.appgestionventa.Modelos.Producto;

import java.util.List;

public interface IProducto {
    public boolean insertProducto(Producto producto);
    public List<Producto> getAll();
    public Producto getProducto(String idProducto);
    public boolean updateProducto(Producto producto);
    public int amount();
}
