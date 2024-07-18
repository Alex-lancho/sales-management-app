package com.example.appgestionventa.Modelos;

import java.io.Serializable;

public class Usuario implements Serializable {
    private String idUsurio ;
    private String nombre;
    private String apellidos;
    private String correo;
    private String usuario ;
    private String contraseña ;
    public Usuario(){}

    public Usuario(String idUsurio, String nombre, String apellidos, String correo, String usuario, String contraseña) {
        this.idUsurio = idUsurio;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getIdUsurio() {
        return idUsurio;
    }

    public void setIdUsurio(String idUsurio) {
        this.idUsurio = idUsurio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    @Override
    public String toString(){
        return "Nombre: "+nombre+"\nApellidos: "+apellidos+"\nCorreo: "+correo+"\nUsuario: "+usuario;
    }
}
