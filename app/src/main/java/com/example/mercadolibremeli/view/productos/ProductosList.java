package com.example.mercadolibremeli.view.productos;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mercadolibremeli.R;
import com.example.mercadolibremeli.adapter.AdapterProductos;
import com.example.mercadolibremeli.model.entities.Productos;

import java.util.ArrayList;

public class ProductosList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        Log.i("ProductosList", "Se crea la vista para mostrar productos");
        ArrayList<Productos> productos = (ArrayList<Productos>) getIntent().getSerializableExtra("Productos");
        RecyclerView recyclerView = findViewById(R.id.recycler1);
        AdapterProductos adapterProducto = new AdapterProductos(productos, this);
        recyclerView.setAdapter(adapterProducto);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setVisibility(View.VISIBLE);
    }
}