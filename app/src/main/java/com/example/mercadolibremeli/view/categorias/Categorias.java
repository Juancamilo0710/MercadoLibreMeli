package com.example.mercadolibremeli.view.categorias;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
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
    private ListView listaCategoria;
    private ProgressBar progressbarLoading;
    private InterfacePresenter presenter;
    private String id_pais;
     boolean flagCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
        listaCategoria=findViewById(R.id.listaPaises);
        progressbarLoading=findViewById(R.id.progressbar_loading);
        flagCategoria = getIntent().getExtras().getBoolean("flag");
        id_pais=((flagCategoria)?getIntent().getExtras().getString("pais"):"MCO");
        presenter = new CategoriasPresenter(this, getApplicationContext());
        getCategorias(id_pais);
    }

    @Override
    public void getCategorias(String id_pais) {
        presenter.getCategorias(id_pais);

    }

    @Override
    public void showCategorias(List<com.example.mercadolibremeli.model.entities.Categorias> categories) {
        Log.i("Categorias", "Consulta  Ok: "+categories.size());
        ArrayList<String> list=new ArrayList<>();
        for (com.example.mercadolibremeli.model.entities.Categorias C:categories) {
            list.add(C.getName());
        }
        ArrayAdapter<String> a=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,list);
        listaCategoria.setAdapter(a);
        listaCategoria.setOnItemClickListener((parent, view, position, id) -> {
            Intent showCategoryIntent = new Intent();
            showCategoryIntent.setClass(Categorias.this, ProductosCategorias.class);
            showCategoryIntent.putExtra("categoria", categories.get(position).getId());
            showCategoryIntent.putExtra("pais",id_pais);
            startActivity(showCategoryIntent);
        });

    }

    @Override
    public void showProgresBar() {

    }

    @Override
    public void hideProgresBar() {

    }
}