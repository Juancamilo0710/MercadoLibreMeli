package com.example.mercadolibremeli.view.paises;

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
import com.example.mercadolibremeli.interfaces.paises.InterfacePresenter;
import com.example.mercadolibremeli.interfaces.paises.InterfaceView;
import com.example.mercadolibremeli.presenter.paises.PaisesPresenter;
import com.example.mercadolibremeli.view.categorias.Categorias;

import java.util.ArrayList;
import java.util.List;

public class Paises extends AppCompatActivity implements InterfaceView {

    private ListView listaPaises;
    private ProgressBar progressBar;
    private LinearLayout notnetwork;
    private InterfacePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);
        initV();
        getPaises();
    }


    @Override
    public void initV() {
        notnetwork = findViewById(R.id.notnetwork);
        progressBar = findViewById(R.id.progressBar);
        listaPaises = findViewById(R.id.listaPaises);
        presenter = new PaisesPresenter(this, getApplicationContext());
    }

    @Override
    public void getPaises() {
        Log.i("Paises", "Inició la Operación");
        showprogressBar();
        disguiseUtilsNetwork();
        presenter.getPaises();
    }

    @Override
    public void reload(View view) {
        getPaises();
    }

    @Override
    public void showPaises(List<com.example.mercadolibremeli.model.entities.Paises> paises) {
        Log.i("Paises", "Se hace intent para mostrar listado de paises");
        ArrayList<String> list=new ArrayList<>();
        for (com.example.mercadolibremeli.model.entities.Paises P:paises) {
            list.add(P.getName());
        }
        ArrayAdapter<String> a=new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,list);
        listaPaises.setAdapter(a);
        listaPaises.setOnItemClickListener((parent, view, position, id) -> {
            Intent showCategoriasIntent = new Intent();
            showCategoriasIntent.setClass(Paises.this, Categorias.class);
            showCategoriasIntent.putExtra("pais", paises.get(position).getId());
            showCategoriasIntent.putExtra("flag", true);
            startActivity(showCategoriasIntent);
        });

    }

    @Override
    public void showprogressBar() {
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
    public void disguiseUtilsNetwork() {
        notnetwork.setVisibility(View.GONE);
    }
}