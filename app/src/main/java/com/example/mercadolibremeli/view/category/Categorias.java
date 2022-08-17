package com.example.mercadolibremeli.view.category;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mercadolibremeli.R;


public class Categorias extends AppCompatActivity {
    private ListView listaCategoria;
    private ProgressBar progressbarLoading;
    private String id_pais;
     boolean flagCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}