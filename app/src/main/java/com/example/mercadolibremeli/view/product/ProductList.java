package com.example.mercadolibremeli.view.product;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mercadolibremeli.R;
import com.example.mercadolibremeli.adapter.ProductAdapter;
import com.example.mercadolibremeli.model.entities.Product;

import java.util.ArrayList;

public class ProductList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProductAdapter adapterProducto;
    private ArrayList<Product> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        recyclerView = findViewById(R.id.recycler1);
        productos=(ArrayList<Product>) getIntent().getSerializableExtra("Productos");
        adapterProducto = new ProductAdapter(productos, this);
        recyclerView.setAdapter(adapterProducto);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setVisibility(View.VISIBLE);
    }
}