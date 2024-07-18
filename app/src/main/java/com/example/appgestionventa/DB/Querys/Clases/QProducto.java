package com.example.appgestionventa.DB.Querys.Clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;

import com.example.appgestionventa.DB.Alert;
import com.example.appgestionventa.DB.Querys.Generic.Generic;
import com.example.appgestionventa.DB.Querys.Interfaces.IProducto;
import com.example.appgestionventa.Modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class QProducto extends Generic implements IProducto {

    List<Producto> productos = new ArrayList<>();
    String[] atributos = {
            "idProducto",
            "nombre",
            "stock",
            "descripcion",
            "precioUnitario",
            "observacion"
    };
    public QProducto(Context context){
        super(context);
    }
    @Override
    public boolean insertProducto(Producto producto) {
        ContentValues values = new ContentValues();
        values.put("idProducto",producto.getIdProducto());
        values.put("nombre",producto.getNombre());
        values.put("stock",producto.getStock());
        values.put("descripcion",producto.getDescripcion());
        values.put("precioUnitario",producto.getPrecioUnitario());
        values.put("observacion",producto.getObservacion());
        try {
            bd.insert("PRODUCTO", null, values);

            Alert.setAlert(alertMessage[0]);
            Alert.setDescripcion("PRODUCTO");
            return true;
        }catch (SQLiteException e){
            Alert.setAlert(alertMessage[1]);
            Alert.setDescripcion("PRODUCTO");
            return false;
        }
    }

    @Override
    public List<Producto> getAll() {
        Producto producto=null;
        try{
            Cursor cursor =bd.query("PRODUCTO",atributos,null,null,null,null,null,null);
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String idProducto = cursor.getString((cursor.getColumnIndex("idProducto")));
                    String nombre = cursor.getString(cursor.getColumnIndex("nombre"));
                    int stock = cursor.getInt(cursor.getColumnIndex("stock"));
                    String descripcion = cursor.getString(cursor.getColumnIndex("descripcion"));
                    double precioUnitario = cursor.getDouble(cursor.getColumnIndex("precioUnitario"));
                    String observacion = cursor.getString(cursor.getColumnIndex("observacion"));
                    producto = new Producto(idProducto, nombre, stock, descripcion, precioUnitario, observacion);
                    productos.add(producto);
                } while (cursor.moveToNext());
                Alert.setAlert(alertMessage[0]);
                Alert.setDescripcion("PRODUCTOS ingresados");
                cursor.close();
            }
            return productos;

        }catch (SQLiteException e){
            Alert.setAlert(alertMessage[1]);
            Alert.setDescripcion(e.getMessage());
            return productos;
        }
    }

    @Override
    public Producto getProducto(String nombreProducto) {
        Producto producto=null;
        String selection="nombre=?";
        String[] selectionArgs={nombreProducto};
        try{
            Cursor cursor=bd.query("Producto",atributos,selection,selectionArgs,null,null,null);
            if (cursor != null && cursor.moveToFirst()) {
                String id = cursor.getString(cursor.getColumnIndex("idProducto"));
                String nom= cursor.getString(cursor.getColumnIndex("nombre"));
                int stk= cursor.getInt(cursor.getColumnIndex("stock"));
                String ds = cursor.getString(cursor.getColumnIndex("descripcion"));
                double pu = cursor.getDouble(cursor.getColumnIndex("precioUnitario"));
                String obs = cursor.getString(cursor.getColumnIndex("observacion"));
                producto = new Producto(id, nom, stk, ds, pu, obs);
                Alert.setAlert(alertMessage[0]);
                Alert.setDescripcion("Producto Obtenido");
                cursor.close();
            }
            return producto;
        }catch (SQLiteException e){
            Alert.setAlert(alertMessage[1]);
            Alert.setDescripcion(e.getMessage());
            return producto;
        }
    }

    @Override
    public boolean updateProducto(Producto producto) {
        ContentValues valores = new ContentValues();
        valores.put("nombre", producto.getNombre());
        valores.put("stock", producto.getStock());
        valores.put("descripcion", producto.getDescripcion());
        valores.put("precioUnitario", producto.getPrecioUnitario());
        valores.put("observacion", producto.getObservacion());

        String whereClause = "idProducto = ?";
        String[] whereArgs = {String.valueOf(producto.getIdProducto())};
        try{
            int filasActualizadas = bd.update("Producto", valores, whereClause, whereArgs);
            return true;

        }catch (SQLiteException e){
            Alert.setAlert(alertMessage[1]);
            Alert.setDescripcion(e.getMessage());
            return false;
        }
    }

    @Override
    public int amount() {

        return 0;
    }
}
