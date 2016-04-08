package mx.gob.sfa.dss.puebla.playlistdescarga.Entidades;

import io.realm.RealmObject;

/**
 * Created by dtit on 06/04/16.
 */
public class Auidos extends RealmObject {
    private int idAudio;
    private int idIdioma;
    private String nombreAudio;
    private String urlAudio;
    private String duracion;
    private int IdSala;
    private int descarga;

    public Auidos(int idAudio, int idIdioma, String nombreAudio, String urlAudio, String duracion, int idSala, int descarga) {
        this.idAudio = idAudio;
        this.idIdioma = idIdioma;
        this.nombreAudio = nombreAudio;
        this.urlAudio = urlAudio;
        this.duracion = duracion;
        IdSala = idSala;
        this.descarga = descarga;
    }

    public Auidos() {
    }

    public int getIdAudio() {
        return idAudio;
    }

    public void setIdAudio(int idAudio) {
        this.idAudio = idAudio;
    }

    public int getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(int idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getNombreAudio() {
        return nombreAudio;
    }

    public void setNombreAudio(String nombreAudio) {
        this.nombreAudio = nombreAudio;
    }

    public String getUrlAudio() {
        return urlAudio;
    }

    public void setUrlAudio(String urlAudio) {
        this.urlAudio = urlAudio;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public int getIdSala() {
        return IdSala;
    }

    public void setIdSala(int idSala) {
        IdSala = idSala;
    }

    public int getDescarga() {
        return descarga;
    }

    public void setDescarga(int descarga) {
        this.descarga = descarga;
    }
}
