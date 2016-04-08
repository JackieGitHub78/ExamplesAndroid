package com.example.root.playlist.com.example.root.layout;

/**
 * Created by dtit on 16/02/16.
 */
public class Textos {

    public static class Texto
    {
        public static String conexionInternet;

        public static void SeleccionarIdioma(int i)
        {
            switch (i)
            {
                case 1:
                    conexionInternet ="its necesaty a conecction the internet";
                    break;
                case 2:
                    conexionInternet="es necesatio la caoneccion a internet";
                    break;
            }
        }

    }


}
