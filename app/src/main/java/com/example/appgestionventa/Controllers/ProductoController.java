package com.example.appgestionventa.Controllers;

import android.content.Context;

import com.example.appgestionventa.DB.Querys.Clases.QProducto;
import com.example.appgestionventa.DB.Querys.Interfaces.IProducto;
import com.example.appgestionventa.Modelos.Producto;

import java.util.List;

public class ProductoController extends GenericController{
    public ProductoController(){}
    public List<Producto> productos(Context context){
        IProducto producto=new QProducto(context);
        return producto.getAll();
    }
    public boolean insertarProducto(Context context, Producto producto){
        IProducto iProducto=new QProducto(context);
        producto.setIdProducto(idCodigo());

        if(iProducto.insertProducto(producto)){
            return true;
        }else{
            return false;
        }
    }
    public Producto getProducto(Context context, String idProducto){
        IProducto iProducto=new QProducto(context);

        if(iProducto.getProducto(idProducto)!=null){
            return iProducto.getProducto(idProducto);
        }else{
            return null;
        }
    }
    public Boolean updateProducto(Context context, Producto producto){
        IProducto iProducto=new QProducto(context);
        if(iProducto.updateProducto(producto)){
            return true;
        }else{
            return false;
        }
    }
}
