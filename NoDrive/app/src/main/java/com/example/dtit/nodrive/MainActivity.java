package com.example.dtit.nodrive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.dtit.nodrive.com.example.dtit.Entidad.NoManeja;
import com.example.dtit.nodrive.com.example.dtit.Utils.NoDriveDays;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //List<NoManeja> Noo = new ArrayList<NoManeja>();

       // Noo = NoDriveDays.ObtieneDiasNomaneja("txc3724",2004);

       NoManeja hola = NoDriveDays.ObtieneDiasNomaneja("TXR3914");




    /*    int ultimo = NoDriveDays.ObtieneUltimoDigito("txc3724");
        int anios = NoDriveDays.ObtieneAnoAuto(2004);
*/
        Log.e("color Sticker: ",hola.getColor());
        Log.e("dia no circula : ", hola.getDia());
       // Log.e("Restriccion sabados ", hola.getRestricSabado());
       // Log.e("clase de auto", hola.getClaseAuto());
        //Log.e("descripcion completa", hola.getDescripcion());
        Log.e("Periodo  uno", hola.getEtpFirsHalf());
        Log.e("Periodo  dos", hola.getEtpSecondHalf());








    }
}
