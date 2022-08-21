package com.example.mercadolibremeli.interfaces.category;

import com.example.mercadolibremeli.model.entities.Categorias;

import java.util.List;

public interface InterfaceView {

    void getCategorias(String id_pais);

    void showApodDetails(List<Categorias> categories);

    void showProgresBar();

    void hideProgresBar();

}
