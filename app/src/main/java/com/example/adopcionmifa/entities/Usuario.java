package com.example.adopcionmifa.entities;

public class Usuario {
    private String NoCliente;
    private String Nombre;
    private String WhatsApp;
    private String Correo;

    public Usuario(String noCliente, String nombre, String whatsApp, String correo) {
        NoCliente = noCliente;
        Nombre = nombre;
        WhatsApp = whatsApp;
        Correo = correo;
    }

    public String getNoCliente() {
        return NoCliente;
    }

    public void setNoCliente(String noCliente) {
        NoCliente = noCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getWhatsApp() {
        return WhatsApp;
    }

    public void setWhatsApp(String whatsApp) {
        WhatsApp = whatsApp;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }
}
