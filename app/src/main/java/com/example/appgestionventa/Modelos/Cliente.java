package com.example.appgestionventa.Modelos;

public class Cliente {
    private String  idCliente;
    private String  nombre;
    private String  correo;
    private String  celular;
    private String  idVenta;
    private Venta venta;

    public Cliente(){}
    public Cliente(String idCliente, String nombre, String correo, String celular, String idVenta) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.idVenta = idVenta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }
    public Venta venta(){
        return this.venta;
    }
}
