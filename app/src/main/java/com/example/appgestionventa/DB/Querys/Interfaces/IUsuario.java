package com.example.appgestionventa.DB.Querys.Interfaces;

import com.example.appgestionventa.Modelos.Usuario;

import java.util.List;

public interface IUsuario {
    public boolean insert(Usuario user);
    public   Usuario getUsuario(String user,String password);
    public List<Usuario> getAll();
}
