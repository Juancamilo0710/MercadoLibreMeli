package com.example.mercadolibremeli.interfaces.categorias;

import com.example.mercadolibremeli.model.entities.Categorias;

import java.util.List;

public interface InterfaceView {

    void getCategorias(String id_pais);

    void showCategorias(List<Categorias> categories);

    void showProgresBar();

    void hideProgresBar();

}
