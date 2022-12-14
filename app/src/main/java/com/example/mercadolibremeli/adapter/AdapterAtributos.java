package com.example.mercadolibremeli.adapter;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mercadolibremeli.R;
import com.example.mercadolibremeli.model.entities.AtributosProductos;

import java.util.ArrayList;

public class AdapterAtributos extends RecyclerView.Adapter<AdapterAtributos.viewHolderAtributos> {

    private ArrayList<AtributosProductos> atributos;
    private Context context;

    public AdapterAtributos(ArrayList<AtributosProductos> atributos, Context context) {
        this.atributos = atributos;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolderAtributos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("AdapterAtributos", "Se infla CardView");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.atributos_item_list, null, false);
        return new viewHolderAtributos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolderAtributos holder, int position) {
        AtributosProductos a = atributos.get(position);
        holder.titulo.setText(a.getName());
        holder.descripcion.setText(a.getValue_name());
    }

    @Override
    public int getItemCount() {
        return atributos.size();
    }

    public class viewHolderAtributos extends RecyclerView.ViewHolder {

        private TextView titulo, descripcion;

        public viewHolderAtributos(@NonNull View itemView) {
            super(itemView);
            titulo = itemView.findViewById(R.id.titulo1);
            descripcion = itemView.findViewById(R.id.descripcion1);
        }
    }
}
