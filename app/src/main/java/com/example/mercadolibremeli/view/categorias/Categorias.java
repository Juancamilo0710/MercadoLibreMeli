package com.example.mercadolibremeli.view.categorias;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mercadolibremeli.R;
import com.example.mercadolibremeli.interfaces.categorias.InterfacePresenter;
import com.example.mercadolibremeli.interfaces.categorias.InterfaceView;
import com.example.mercadolibremeli.presenter.categorias.CategoriasPresenter;
import com.example.mercadolibremeli.view.ProductosCategoias.ProductosCategorias;

import java.util.ArrayList;
import java.util.List;


public class Categorias extends AppCompatActivity implements InterfaceView {

    private String id_pais;
    private boolean flagCategoria;
    private ListView listaCategoria;
    private ProgressBar progressBar;
    private LinearLayout notnetwork;
    private InterfacePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
        initV();
        getCategorias(id_pais);
    }

    @Override
    public void initV() {
        id_pais = ((flagCategoria) ? getIntent().getExtras().getString("pais") : "MCO");
        presenter = new CategoriasPresenter(this, getApplicationContext());
        notnetwork = findViewById(R.id.notnetwork);
        progressBar = findViewById(R.id.progressBar);
        flagCategoria = getIntent().getExtras().getBoolean("flag");
        listaCategoria = findViewById(R.id.listaPaises);
    }

    @Override
    public void getCategorias(String idPais) {
        showProgresBar();
        presenter.getCategorias(idPais);
    }

    @Override
    public void showCategorias(List<com.example.mercadolibremeli.model.entities.Categorias> categories) {
        Log.i("Categorias", "Consulta  Ok: " + categories.size());
        ArrayList<String> list = new ArrayList<>();
        for (com.example.mercadolibremeli.model.entities.Categorias C : categories) {
            list.add(C.getName());
        }
        ArrayAdapter<String> a = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, list);
        listaCategoria.setAdapter(a);
        listaCategoria.setOnItemClickListener((parent, view, position, id) -> {
            Intent showCategoryIntent = new Intent();
            showCategoryIntent.setClass(Categorias.this, ProductosCategorias.class);
            showCategoryIntent.putExtra("categoria", categories.get(position).getId());
            showCategoryIntent.putExtra("pais", id_pais);
            startActivity(showCategoryIntent);
        });

    }

    @Override
    public void showProgresBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void disguiseprogressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showUtilsNetwork() {
        notnetwork.setVisibility(View.VISIBLE);
    }

    @Override
    public void disquiseUtilsNetwork() {
        notnetwork.setVisibility(View.GONE);
    }

    @Override
    public void reload(View view) {
        disquiseUtilsNetwork();
        getCategorias(id_pais);
    }
}