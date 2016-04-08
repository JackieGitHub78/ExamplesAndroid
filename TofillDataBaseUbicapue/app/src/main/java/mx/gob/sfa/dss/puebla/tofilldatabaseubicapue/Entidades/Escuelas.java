package mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades;

import io.realm.RealmObject;

/**
 * Created by dtit on 11/03/16.
 */
public class Escuelas extends RealmObject {

    //@PrimaryKey
    private int id_escuela;
    //@Required
    private int id_municipio;
    private int region_socioeconomica;
    //@Required
    private int tipo_escuela;
    private String entidad;
    private String municipio;
    private String localidad;
    private String ambito;
    private String clave;
    private String turno;
    //@Required
    private String nombre;
    //@Required
    private String servicio;
    //@Required
    private String control;
    private String opciones;
    private String direccion;
    private String telefono;
    //@Required
    private String latitud;
    //@Required
    private String longitud;
    private String georeferencia;


    public Escuelas(int id_escuela, int id_municipio, int region_socioeconomica, int tipo_escuela, String entidad, String municipio, String localidad, String ambito, String clave, String turno, String nombre, String servicio, String control, String opciones, String direccion, String telefono, String latitud, String longitud, String georeferencia) {
        this.id_escuela = id_escuela;
        this.id_municipio = id_municipio;
        this.region_socioeconomica = region_socioeconomica;
        this.tipo_escuela = tipo_escuela;
        this.entidad = entidad;
        this.municipio = municipio;
        this.localidad = localidad;
        this.ambito = ambito;
        this.clave = clave;
        this.turno = turno;
        this.nombre = nombre;
        this.servicio = servicio;
        this.control = control;
        this.opciones = opciones;
        this.direccion = direccion;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
        this.georeferencia = georeferencia;
    }

    public Escuelas() {
    }

    public int getId_escuela() {
        return id_escuela;
    }

    public void setId_escuela(int id_escuela) {
        this.id_escuela = id_escuela;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }

    public int getRegion_socioeconomica() {
        return region_socioeconomica;
    }

    public void setRegion_socioeconomica(int region_socioeconomica) {
        this.region_socioeconomica = region_socioeconomica;
    }

    public int getTipo_escuela() {
        return tipo_escuela;
    }

    public void setTipo_escuela(int tipo_escuela) {
        this.tipo_escuela = tipo_escuela;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getOpciones() {
        return opciones;
    }

    public void setOpciones(String opciones) {
        this.opciones = opciones;
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
}
