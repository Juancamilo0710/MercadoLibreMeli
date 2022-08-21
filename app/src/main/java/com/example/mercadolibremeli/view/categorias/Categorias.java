package com.example.mercadolibremeli.view.category;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mercadolibremeli.R;
import com.example.mercadolibremeli.interfaces.category.InterfaceView;
import com.example.mercadolibremeli.presenter.Category.CategoryPresenter;
import com.example.mercadolibremeli.presenter.paises.PaisesPresenter;


public class Categorias extends AppCompatActivity implements InterfaceView {
    private ListView listaCategoria;
    private ProgressBar progressbarLoading;
    private CategoryPresenter presenter;
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
        presenter = new CategoryPresenter(this);
        requestData(id_pais);
    }
}