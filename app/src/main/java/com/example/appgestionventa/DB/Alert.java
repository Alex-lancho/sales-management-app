package com.example.appgestionventa.DB;

public class Alert {
    private static String alert;
    private static String descripcion;

    public static String getDescripcion() {
        return descripcion;
    }

    public static void setDescripcion(String descripcion) {
        Alert.descripcion = descripcion;
    }

    public static String getAlert() {
        return alert;
    }

    public static void setAlert(String alert) {
        Alert.alert = alert;
    }
}
