package com.example.dtit.recyclerview_cardview.com.example.dtit.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dtit.recyclerview_cardview.R;
import com.example.dtit.recyclerview_cardview.com.example.dtit.Entidades.Personas;

import java.util.List;

/**
 * Created by dtit on 03/03/16.
 */
public class AdapterPersonas extends RecyclerView.Adapter<AdapterPersonas.PersonasViewHolder>
{


    private List<Personas> Listapersonas;



    public AdapterPersonas(List<Personas> listapersonas) {
        Listapersonas = listapersonas;
    }

    @Override
    public PersonasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View ItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_personas,parent,false);
        return new PersonasViewHolder(ItemView);
    }

    @Override
    public void onBindViewHolder(PersonasViewHolder holder, int position) {

        Personas ci = Listapersonas.get(position);//obtenemos la posicion

        holder.txtNombre.setText(ci.getNombre());
        holder.txtUsuario.setText(ci.getUsuario());
        holder.txttwitter.setText(ci.getTwitter());

        final Personas subjet = Listapersonas.get(position);

    }

    @Override
    public int getItemCount() {
        return Listapersonas.size();
    }

    public static class PersonasViewHolder extends RecyclerView.ViewHolder
    {
        protected TextView txtNombre;
        protected TextView txtUsuario;
        protected TextView txttwitter;
        protected CardView Car_view_peersonas;

        public PersonasViewHolder (View v)
        {
            super(v);
            txtNombre = (TextView) v.findViewById(R.id.TxtNombre);
            txtUsuario = (TextView) v.findViewById(R.id.txtUsuairo);
            txttwitter = (TextView) v.findViewById(R.id.Txtwitter);
            Car_view_peersonas = (CardView) v.findViewById(R.id.card_view);
        }

    }

}
