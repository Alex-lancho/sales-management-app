package com.example.appgestionventa.Controllers;

import android.content.Context;

import com.example.appgestionventa.DB.Querys.Clases.QProducto;
import com.example.appgestionventa.DB.Querys.Clases.QUsuario;
import com.example.appgestionventa.DB.Querys.Interfaces.IProducto;
import com.example.appgestionventa.DB.Querys.Interfaces.IUsuario;
import com.example.appgestionventa.Modelos.Producto;
import com.example.appgestionventa.Modelos.Usuario;

import java.security.SecureRandom;
import java.util.List;

public class UsuarioController extends GenericController{
    public UsuarioController(){}
    public Usuario login(String user, String password, Context context){
        IUsuario usuario=new QUsuario(context);
        if(usuario.getUsuario(user,password)!=null){
            return usuario.getUsuario(user,password);
        }
        return null;
    }
    public boolean insertar(Usuario user,Context context){
        IUsuario usuario=new QUsuario(context);
        user.setIdUsurio(idCodigo());
        if(usuario.insert(user)){
            return true;
        }
        return false;
    }
    public List<Usuario> usuarios(Context context){
        IUsuario usuario=new QUsuario(context);
        return usuario.getAll();
    }

}
