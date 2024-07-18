package com.example.appgestionventa.DB.Querys.Interfaces;

import com.example.appgestionventa.DB.Querys.Generic.Generic;
import com.example.appgestionventa.Modelos.Detalle;
import com.example.appgestionventa.Modelos.Producto;

import java.util.List;

public interface IDetalle{
    public boolean insertProducto(Producto producto);
    public List<Detalle> getAll();
    public Detalle getProducto(String idDetalle);
    public boolean updateDetalle(Detalle detalle);
    public int amount();
}
