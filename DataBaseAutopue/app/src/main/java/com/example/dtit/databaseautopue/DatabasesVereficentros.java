package com.example.dtit.databaseautopue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.dtit.databaseautopue.com.example.dtit.Entidades.Vereficentros;
import com.example.dtit.databaseautopue.com.example.dtit.Listas.ListaVerificacion;

import java.util.List;

public class DatabasesVereficentros extends AppCompatActivity {

    List<Vereficentros> prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databases_vereficentros);

        prueba = ListaVerificacion.DataBaseVereficentros();

        for(Vereficentros v:prueba)
        {
            Log.e("**",v.getNombre());

        }

    }
}
