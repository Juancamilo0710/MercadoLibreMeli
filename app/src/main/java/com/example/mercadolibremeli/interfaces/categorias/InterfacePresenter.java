package com.example.mercadolibremeli.interfaces.categorias;

import com.example.mercadolibremeli.model.entities.Categorias;

import java.util.List;

public interface InterfacePresenter {

    void getCategorias(String id_pais);

    void showCategorias(List<Categorias> categories);

}
