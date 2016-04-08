package com.example.dtit.recyclerview_cardview.com.example.dtit.Entidades;

/**
 * Created by dtit on 03/03/16.
 */
public class Personas {

    private String nombre;
    private String usuario;
    private String twitter;

    public Personas(String nombre, String usuario, String twitter) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.twitter = twitter;
    }

    public Personas() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
}
