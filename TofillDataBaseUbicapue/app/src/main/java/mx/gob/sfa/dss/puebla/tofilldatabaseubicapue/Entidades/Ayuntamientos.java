package mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades;

import io.realm.RealmObject;

/**
 * Created by dtit on 11/03/16.
 */
public class Ayuntamientos extends RealmObject {
    //@PrimaryKey
    private int id;
    //@Required
    private  String nombre;
    //@Required
    private String alcalde;
    //@Required
    private String direccion;
    //@Required
    private String telefono;
    private String email;
    private String web;
    //@Required
    private String latitud;
    //@Required
    private String longitud;
    //@Required
    private String georeferencia;
    //@Required
    private int id_municipio;
    //@Required
    private String municipio;


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

    public String getAlcalde() {
        return alcalde;
    }

    public void setAlcalde(String alcalde) {
        this.alcalde = alcalde;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
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

    public String getGeoreferencia() {
        return georeferencia;
    }

    public void setGeoreferencia(String georeferencia) {
        this.georeferencia = georeferencia;
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
}
