package com.example.appgestionventa.DB.Querys.Generic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.appgestionventa.DB.Alert;
import com.example.appgestionventa.DB.SQLLite;

public class Generic {
    protected SQLiteDatabase bd;
    protected SQLLite dbHelper;
    String tipo="";
    public String [] alertMessage={"success,","warning","error","remove"};
    public Generic(Context context){
        dbHelper = new SQLLite(context);
        bd = dbHelper.getWritableDatabase();
    }
}
