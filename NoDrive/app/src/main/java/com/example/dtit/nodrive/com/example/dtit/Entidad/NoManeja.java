package com.example.dtit.nodrive.com.example.dtit.Entidad;

/**
 * Created by dtit on 23/02/16.
 */
public class NoManeja {

    private String ClaseAuto;
    private String Color;
    private String RestricSabado;
    private String Emisiones;
    private String Dia;
    private String etpFirsHalf;
    private String etpSecondHalf;
    private String descripcion;

    public NoManeja(String claseAuto, String color, String restricSabado, String emisiones, String dia, String etpFirsHalf, String etpSecondHalf, String descripcion) {
        ClaseAuto = claseAuto;
        Color = color;
        RestricSabado = restricSabado;
        Emisiones = emisiones;
        Dia = dia;
        this.etpFirsHalf = etpFirsHalf;
        this.etpSecondHalf = etpSecondHalf;
        this.descripcion = descripcion;
    }

    public NoManeja() {
    }

    public String getClaseAuto() {
        return ClaseAuto;
    }

    public void setClaseAuto(String claseAuto) {
        ClaseAuto = claseAuto;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getRestricSabado() {
        return RestricSabado;
    }

    public void setRestricSabado(String restricSabado) {
        RestricSabado = restricSabado;
    }

    public String getEmisiones() {
        return Emisiones;
    }

    public void setEmisiones(String emisiones) {
        Emisiones = emisiones;
    }

    public String getDia() {
        return Dia;
    }

    public void setDia(String dia) {
        Dia = dia;
    }

    public String getEtpFirsHalf() {
        return etpFirsHalf;
    }

    public void setEtpFirsHalf(String etpFirsHalf) {
        this.etpFirsHalf = etpFirsHalf;
    }

    public String getEtpSecondHalf() {
        return etpSecondHalf;
    }

    public void setEtpSecondHalf(String etpSecondHalf) {
        this.etpSecondHalf = etpSecondHalf;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
