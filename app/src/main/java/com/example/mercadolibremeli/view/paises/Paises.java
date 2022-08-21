package com.example.mercadolibremeli.view.paises;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
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

    ListView listaPaises;
    private InterfacePresenter presenter;
    private ProgressBar progressbarLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paises);
        listaPaises=findViewById(R.id.listaPaises);
        presenter = new PaisesPresenter(this, getApplicationContext());
        getPaises();

    }


    @Override
    public void getPaises() {
        Log.i("Paises", "Solicitar paises");
        presenter.getPaises();
    }

    @Override
    public void showProgresBar() {

    }

    @Override
    public void hideProgresBar() {

    }

    @Override
    public void showPaises(List<com.example.mercadolibremeli.model.entities.Paises> paises) {
        Log.i("Paises", "Solicitud   Ok: "+paises.size());
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
}