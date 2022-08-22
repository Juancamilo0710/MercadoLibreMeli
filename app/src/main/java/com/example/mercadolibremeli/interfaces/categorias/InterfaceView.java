package com.example.mercadolibremeli.interfaces.categorias;

import android.view.View;

import com.example.mercadolibremeli.model.entities.Categorias;

import java.util.List;

public interface InterfaceView {

    void initV();

    void getCategorias(String id_pais);

    void showCategorias(List<Categorias> categories);

    void showProgresBar();

    void disguiseprogressBar();

    void showUtilsNetwork();

    void disquiseUtilsNetwork();

    void reload(View view);

}
