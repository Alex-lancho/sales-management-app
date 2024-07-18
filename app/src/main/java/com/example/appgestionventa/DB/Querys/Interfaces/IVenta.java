package com.example.appgestionventa.DB.Querys.Interfaces;

import com.example.appgestionventa.Modelos.Venta;

import java.util.List;

public interface IVenta {
    public boolean insertVenta(Venta venta);
    public List<Venta> getAll();
    public Venta getVenta(String idVenta);
    public boolean updateVenta(Venta venta);
    public int amount();
}
