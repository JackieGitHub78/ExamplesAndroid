package com.example.dtit.databaseautopue.com.example.dtit.Entidades;

/**
 * Created by dtit on 26/02/16.
 */
public class Vereficentros {

    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String horario;
    private String latitud;
    private String longitud;
    private int id_municipio;
    private String municipio;

    public Vereficentros(int id, String nombre, String direccion, String telefono, String horario, String latitud, String longitud, int id_municipio, String municipio) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horario = horario;
        this.latitud = latitud;
        this.longitud = longitud;
        this.id_municipio = id_municipio;
        this.municipio = municipio;
    }

    public Vereficentros() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }


    @Override
    public String toString() {
        return "Vereficentros{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", horario='" + horario + '\'' +
                ", latitud='" + latitud + '\'' +
                ", longitud='" + longitud + '\'' +
                ", id_municipio=" + id_municipio +
                ", municipio='" + municipio + '\'' +
                '}';
    }
}
