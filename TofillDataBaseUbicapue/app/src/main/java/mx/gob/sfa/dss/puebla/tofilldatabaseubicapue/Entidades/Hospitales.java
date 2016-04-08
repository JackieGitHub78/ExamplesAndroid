package mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades;

import io.realm.RealmObject;

/**
 * Created by dtit on 11/03/16.
 */
public class Hospitales extends RealmObject{
    //@PrimaryKey
    private int id_hospital;
    //@Required
    private int tipo;
    //@Required
    private int id_municipio;
    //@Required
    private String municipio;
    //@Required
    private String nombre;
    private String telefono;
    //@Required
    private String direccion;
    private int camas;
    private int consultorios;
    private int farmacias;
    private int laboratorios;
    private int centros_salud_atendidos;
    private String detalles;
    private String georeferencia;
    //@Required
    private String latitud;
    //@Required
    private String longitud;
    private String servicios_que_proporciona;


    public int getId_hospital() {
        return id_hospital;
    }

    public void setId_hospital(int id_hospital) {
        this.id_hospital = id_hospital;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCamas() {
        return camas;
    }

    public void setCamas(int camas) {
        this.camas = camas;
    }

    public int getConsultorios() {
        return consultorios;
    }

    public void setConsultorios(int consultorios) {
        this.consultorios = consultorios;
    }

    public int getFarmacias() {
        return farmacias;
    }

    public void setFarmacias(int farmacias) {
        this.farmacias = farmacias;
    }

    public int getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(int laboratorios) {
        this.laboratorios = laboratorios;
    }

    public int getCentros_salud_atendidos() {
        return centros_salud_atendidos;
    }

    public void setCentros_salud_atendidos(int centros_salud_atendidos) {
        this.centros_salud_atendidos = centros_salud_atendidos;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getGeoreferencia() {
        return georeferencia;
    }

    public void setGeoreferencia(String georeferencia) {
        this.georeferencia = georeferencia;
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

    public String getServicios_que_proporciona() {
        return servicios_que_proporciona;
    }

    public void setServicios_que_proporciona(String servicios_que_proporciona) {
        this.servicios_que_proporciona = servicios_que_proporciona;
    }
}
