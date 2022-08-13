package com.example.adopcionmifa.utils;

public class Utils {
    //Tabla y campos de la base de datos
    public static final String TABLA_USUARIO = "usuarios";
    public static final String NO_CLIENTE = "no_cliente";
    public static final String NOMBRE = "nombre";
    public static final String WHATSAPP = "whatsapp";
    public static final String CORREO = "correo";

    public static final String CREATE_TABLE_USUARIO = "CREATE TABLE" + TABLA_USUARIO + " ("
            + NO_CLIENTE + "INTEGER PRIMARY KEY UNIQUE, " + NOMBRE + " TEXT, " + WHATSAPP +
            "TEXT, " + CORREO + "";
}
