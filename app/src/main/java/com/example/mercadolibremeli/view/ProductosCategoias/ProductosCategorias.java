package com.example.mercadolibremeli.view.ProductosCategoias;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mercadolibremeli.R;
import com.example.mercadolibremeli.adapter.AdapterProductos;
import com.example.mercadolibremeli.interfaces.productosCategorias.InterfacePresenter;
import com.example.mercadolibremeli.interfaces.productosCategorias.InterfaceView;
import com.example.mercadolibremeli.model.entities.Productos;
import com.example.mercadolibremeli.presenter.productosCategorias.ProductosCategoriasPresenter;

import java.util.ArrayList;

public class ProductosCategorias extends AppCompatActivity implements InterfaceView {
    private String id_pais;
    private String id_categoria;
    private InterfacePresenter mPresenter;
    private LinearLayout errorbusqueda;
    private ProgressBar progressbarLoading;
    private TextView reintento;
    private LinearLayout notnetwork;
    private LinearLayout noResult;
    private ImageView menu;
    private RecyclerView recyclerView;
    private AdapterProductos adapterProductos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_category);
        mPresenter = new ProductosCategoriasPresenter(this,getApplicationContext());
        recyclerView = findViewById(R.id.recycler1);
        errorbusqueda=findViewById(R.id.errorbusqueda);
        reintento=findViewById(R.id.reintento);
        notnetwork=findViewById(R.id.notnetwork);
        menu=findViewById(R.id.menu);
        noResult=findViewById(R.id.errorbusqueda);
        progressbarLoading=findViewById(R.id.progressbar_loading);
        id_pais=getIntent().getExtras().getString("pais");
        id_categoria=getIntent().getExtras().getString("categoria");
        getProductCategorias(id_pais,id_categoria);
    }


    @Override
    public void getProductCategorias(String id_pais, String id_categoria) {
        Log.i("ProductsCategory", "Productos por categoria "+"id_pais: "+id_pais+"  id_categoria  "+id_categoria);
        mPresenter.getProductCategorias(id_pais,id_categoria);

    }

    @Override
    public void showProgresBar() {
        progressbarLoading.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgresBar() {
        progressbarLoading.setVisibility(View.GONE);

    }

    @Override
    public void showProductCategorias(ArrayList<Productos> productos) {
        Log.i("ProductsCategory", "Productos por categoria "+"id_pais: "+id_pais+"  id_categoria  "+id_categoria);
        adapterProductos = new AdapterProductos(productos,this);
        recyclerView.setAdapter(adapterProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setVisibility(View.VISIBLE);
    }

}