package com.example.mercadolibremeli.view.productos;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.mercadolibremeli.R;
import com.example.mercadolibremeli.adapter.AdapterAtributos;
import com.example.mercadolibremeli.model.entities.AtributosProductos;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductosDetail extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterAtributos adapterAtributos;
    private ArrayList<AtributosProductos> atributosArrayList;
    Bundle datos;
    TextView titulo,precio;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        datos = getIntent().getExtras();
        atributosArrayList =(ArrayList<AtributosProductos>) getIntent().getSerializableExtra("Atributos");
        recyclerView = findViewById(R.id.recycler2);
        titulo = findViewById(R.id.txt2);
        titulo.setText(datos.getString("titulo"));
        precio = findViewById(R.id.precio);
        precio.setText(String.valueOf(new DecimalFormat("###,###,###").format(datos.get("precio"))));
        img = findViewById(R.id.img2);
        Glide.with(this).load(datos.getString("img")
                .replaceFirst("http","https"))
                .override(300,400)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL).into(img);
        mostrarAtributos();
    }


    void mostrarAtributos(){

        adapterAtributos = new AdapterAtributos(atributosArrayList,this);
        recyclerView.setAdapter(adapterAtributos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setVisibility(View.VISIBLE);
    }

}