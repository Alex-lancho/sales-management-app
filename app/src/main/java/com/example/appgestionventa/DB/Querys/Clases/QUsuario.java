package com.example.appgestionventa.DB.Querys.Clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;

import com.example.appgestionventa.DB.Alert;
import com.example.appgestionventa.DB.Querys.Generic.Generic;
import com.example.appgestionventa.DB.Querys.Interfaces.IUsuario;
import com.example.appgestionventa.Modelos.Producto;
import com.example.appgestionventa.Modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class QUsuario extends Generic implements IUsuario {
    List<Usuario> usuarios = new ArrayList<>();
    String atributo[]={"idUsurio","nombre","apellidos","correo","usuario","contraseña"};
    public QUsuario(Context context){
        super(context);
    }
    @Override
    public boolean insert(Usuario user) {
        ContentValues values = new ContentValues();
        values.put(atributo[0], user.getIdUsurio());
        values.put(atributo[1], user.getNombre());
        values.put(atributo[2], user.getApellidos());
        values.put(atributo[3], user.getCorreo());
        values.put(atributo[4], user.getUsuario());
        values.put(atributo[5], user.getContraseña());
        try {
            bd.insert("USUARIO", null, values);

            Alert.setAlert(alertMessage[0]);
            Alert.setDescripcion("Se creo el Usuario");
            return true;
        }catch (SQLiteException e){
            Alert.setAlert(alertMessage[1]);
            Alert.setDescripcion(e.getMessage());
            return false;
        }
    }

    @Override
    public Usuario getUsuario(String user, String password) {
        Usuario usuarioEncontrado = null;
       try{
           String selection="usuario=? AND contraseña=?";
           String[] selectionArgs={user,password};
           Cursor cursor=bd.query("USUARIO",atributo,selection,selectionArgs,null,null,null,null);
           if(cursor!=null && cursor.moveToFirst()){
               String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
               String apellidos = cursor.getString(cursor.getColumnIndex("apellidos"));
               String correo = cursor.getString(cursor.getColumnIndex("correo"));
               String usuario = cursor.getString(cursor.getColumnIndex("usuario"));
               usuarioEncontrado = new Usuario();
               usuarioEncontrado.setNombre(nombre);
               usuarioEncontrado.setApellidos(apellidos);
               usuarioEncontrado.setCorreo(correo);
               usuarioEncontrado.setUsuario(usuario);
               Alert.setAlert(alertMessage[0]);
               Alert.setDescripcion("Usuario encontrado");
               cursor.close();
           }
           return usuarioEncontrado;
       }catch (SQLiteException e){
           Alert.setAlert(alertMessage[1]);
           Alert.setDescripcion(e.getMessage());
           return usuarioEncontrado;
       }
    }

    public List<Usuario> getAll(){
        Usuario usuario=null;
        try{
            Cursor cursor =bd.query("USUARIO",atributo,null,null,null,null,null,null);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String idUsuario = cursor.getString(cursor.getColumnIndex("idUsurio"));
                    String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                    String apellidos = cursor.getString(cursor.getColumnIndex("apellidos"));
                    String correo = cursor.getString(cursor.getColumnIndex("correo"));
                    String usuarioQ = cursor.getString(cursor.getColumnIndex("usuario"));
                    String contraseñaQ = cursor.getString(cursor.getColumnIndex("contraseña"));
                    usuario = new Usuario(idUsuario, nombre, apellidos,correo,usuarioQ,contraseñaQ);
                    usuarios.add(usuario);
                } while (cursor.moveToNext());
                Alert.setAlert(alertMessage[0]);
                Alert.setDescripcion("PRODUCTOS ingresados");
                cursor.close();
            }
            return usuarios;

        }catch (SQLiteException e){
            Alert.setAlert(alertMessage[1]);
            Alert.setDescripcion(e.getMessage());
            return usuarios;
        }
    }
}
