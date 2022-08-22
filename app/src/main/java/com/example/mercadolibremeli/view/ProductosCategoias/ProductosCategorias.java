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
    private ImageView menu;
    private TextView reintento;
    private String id_categoria;
    private LinearLayout noResult;
    private LinearLayout notnetwork;
    private ProgressBar progressBar;
    private LinearLayout errorbusqueda;
    private RecyclerView recyclerView;
    private InterfacePresenter mPresenter;
    private AdapterProductos adapterProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_category);
        initV();
        getProductCategorias(id_pais, id_categoria);
    }


    @Override
    public void initV() {
        menu = findViewById(R.id.menu);
        id_pais = getIntent().getExtras().getString("pais");
        noResult = findViewById(R.id.errorbusqueda);
        reintento = findViewById(R.id.reintento);
        mPresenter = new ProductosCategoriasPresenter(this, getApplicationContext());
        notnetwork = findViewById(R.id.notnetwork);
        progressBar = findViewById(R.id.progressBar);
        id_categoria = getIntent().getExtras().getString("categoria");
        recyclerView = findViewById(R.id.recycler1);
        errorbusqueda = findViewById(R.id.errorbusqueda);
    }

    @Override
    public void getProductCategorias(String id_pais, String id_categoria) {
        Log.i("ProductosCategorias", "Productos por categoria " + "id_pais: " + id_pais + "  id_categoria  " + id_categoria);
        showProgresBar();
        disguiseUtilsNetwork();
        mPresenter.getProductCategorias(id_pais, id_categoria);

    }

    @Override
    public void showProgresBar() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void disguiseProgresBar() {
        progressBar.setVisibility(View.GONE);

    }

    @Override
    public void showProductCategorias(ArrayList<Productos> productos) {
        Log.i("ProductosCategorias", "Productos por categoria " + "id_pais: " + id_pais + "  id_categoria  " + id_categoria);
        adapterProductos = new AdapterProductos(productos, this);
        recyclerView.setAdapter(adapterProductos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showUtilsNetwork() {
        notnetwork.setVisibility(View.VISIBLE);
    }

    @Override
    public void disguiseUtilsNetwork() {
        notnetwork.setVisibility(View.GONE);
    }

    @Override
    public void reload(View view) {
        getProductCategorias(id_pais, id_categoria);
    }

}