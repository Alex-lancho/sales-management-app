package com.example.appgestionventa.Modelos;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private String idVenta;
    private String fecha;
    private String observacion;
    private String idUsurio;
    private Usuario usuario;
    private List<Detalle> detalles;
    private List<Cliente> clientes;
    public Venta(){}

    public Venta(String idVenta, String fecha, String observacion, String idUsurio) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.observacion = observacion;
        this.idUsurio = idUsurio;
        detalles=new ArrayList<>();
        clientes=new ArrayList<>();
    }

    public List<Detalle> getDetalles() {
        //obtener detalles y almacenar en el arreglo
        return detalles;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Usuario getUsuario() {
        //Realizar consultas y guardar en usuario
        return usuario;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getIdUsurio() {
        return idUsurio;
    }

    public void setIdUsurio(String idUsurio) {
        this.idUsurio = idUsurio;
    }
}

