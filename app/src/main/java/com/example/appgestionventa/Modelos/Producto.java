package com.example.appgestionventa.Modelos;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String idProducto;
    private String nombre;
    private String descripcion;
    private double precioUnitario;
    private int stock;
    private String observacion;
    private List<Detalle>detalles;
    public Producto(){}

    public Producto(String idProducto, String nombre,int stock, String descripcion, double precioUnitario, String observacion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.observacion = observacion;
        this.stock=stock;
        detalles=new ArrayList<>();
    }

    public List<Detalle> getDetalles() {

        return detalles;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    @Override
    public String toString(){
        return nombre+"\nPrecio: "+precioUnitario+"\nStock: "+stock;
    }
}
