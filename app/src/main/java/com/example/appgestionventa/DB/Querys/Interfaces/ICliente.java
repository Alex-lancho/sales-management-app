package com.example.appgestionventa.DB.Querys.Interfaces;

import com.example.appgestionventa.Modelos.Cliente;

import java.util.List;

public interface ICliente {
    public boolean insertCliente(Cliente cliente);
    public List<Cliente>getAll();
}
