package mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades;

import io.realm.RealmObject;

/**
 * Created by dtit on 11/03/16.
 */
public class Cis extends RealmObject {

    // @PrimaryKey
    private int id;
    //@Required
    private String cis;
    //@Required
    private String direccion;
    private String telefono;
    // @Required
    private String latitud;
    //@Required
    private String longitud;
    private int status;
    private String descripcion;
    private String horarios;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCis() {
        return cis;
    }

    public void setCis(String cis) {
        this.cis = cis;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }
}
