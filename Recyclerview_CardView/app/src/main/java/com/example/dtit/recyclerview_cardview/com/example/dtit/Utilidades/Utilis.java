package com.example.dtit.recyclerview_cardview.com.example.dtit.Utilidades;

import com.example.dtit.recyclerview_cardview.com.example.dtit.Entidades.Personas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dtit on 03/03/16.
 */
public class Utilis {

    public static List<Personas> llenalistapersonas()

    {
        List<Personas> datosPersonas = new ArrayList<Personas>();

        datosPersonas.add(new Personas("david","hackro","@hackro"));
        datosPersonas.add(new Personas("jessi","weruchita","@weruchita"));
        datosPersonas.add(new Personas("libna","lib","@libna"));
        datosPersonas.add(new Personas("isabel","isa","@isabel"));
        datosPersonas.add(new Personas("jackie","itoo","@itoo"));
        datosPersonas.add(new Personas("libna","lib","@libna"));
        datosPersonas.add(new Personas("isabel","isa","@isabel"));
        datosPersonas.add(new Personas("jackie","itoo","@itoo"));

        return datosPersonas;
    }


}
