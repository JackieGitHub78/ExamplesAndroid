package com.example.root.playlist.com.example.root.Entidades;

/**
 * Created by root on 14/02/16.
 */
public class Audio {

    private int IdAudio;
    private int idIdioma;
    private String nombreAudio;
    private String urlAudio;
    private String duracion;
    private Boolean descarga;

    public Audio() {
    }

    public Audio(int idAudio, int idIdioma, String nombreAudio, String urlAudio, String duracion, Boolean descarga) {
        IdAudio = idAudio;
        this.idIdioma = idIdioma;
        this.nombreAudio = nombreAudio;
        this.urlAudio = urlAudio;
        this.duracion = duracion;
        this.descarga = descarga;
    }

    public int getIdAudio() {
        return IdAudio;
    }

    public void setIdAudio(int idAudio) {
        IdAudio = idAudio;
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

    public Boolean getDescarga() {
        return descarga;
    }

    public void setDescarga(Boolean descarga) {
        this.descarga = descarga;
    }
}
