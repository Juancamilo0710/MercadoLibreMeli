package com.example.mercadolibremeli.interfaces.categorias;

import com.example.mercadolibremeli.model.entities.Categorias;

import java.util.List;

public interface InterfaceModel {

    void getCategorias(String id_pais);

    void getCategoriasFromApi(String id_pais);

}
