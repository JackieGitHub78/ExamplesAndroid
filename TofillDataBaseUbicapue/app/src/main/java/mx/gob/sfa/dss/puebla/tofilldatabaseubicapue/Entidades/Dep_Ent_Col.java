package mx.gob.sfa.dss.puebla.tofilldatabaseubicapue.Entidades;

import io.realm.RealmObject;

/**
 * Created by dtit on 11/03/16.
 */
public class Dep_Ent_Col extends RealmObject {
    //@PrimaryKey
    private int id;
    //@Required
    private String dep_ent;
    private String direccion;
    private String telefono;
    //@Required
    private String latitud;
    //@Required
    private String longitud;
    //@Required
    private int tipo;
    private int status;
    private String descripcion;
    private String tramites;
    private String horario;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDep_ent() {
        return dep_ent;
    }

    public void setDep_ent(String dep_ent) {
        this.dep_ent = dep_ent;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
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

    public String getTramites() {
        return tramites;
    }

    public void setTramites(String tramites) {
        this.tramites = tramites;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
