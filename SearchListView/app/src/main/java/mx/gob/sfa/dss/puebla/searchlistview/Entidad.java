package mx.gob.sfa.dss.puebla.searchlistview;

/**
 * Created by dtit on 31/03/16.
 */
public class Entidad {
    private String nombre;
    private String telefono;

    public Entidad(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Entidad() {
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
}
