package com.example.dtit.recyclerview_cardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dtit.recyclerview_cardview.com.example.dtit.Adapters.AdapterPersonas;
import com.example.dtit.recyclerview_cardview.com.example.dtit.Entidades.Personas;
import com.example.dtit.recyclerview_cardview.com.example.dtit.Utilidades.Utilis;

import java.util.ArrayList;
import java.util.List;

public class Principal_RecicleyView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal__recicley_view);

        RecyclerView recListPersonas = (RecyclerView)findViewById(R.id.cardListPersonas);
        recListPersonas.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recListPersonas.setLayoutManager(llm);
        List<Personas> lp = new ArrayList<Personas>();
        lp= Utilis.llenalistapersonas();
        AdapterPersonas ca = new AdapterPersonas(lp);
        recListPersonas.setAdapter(ca);



    }
}
