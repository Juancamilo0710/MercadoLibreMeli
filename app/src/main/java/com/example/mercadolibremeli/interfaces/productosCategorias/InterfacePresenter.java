package com.example.mercadolibremeli.interfaces.productosCategorias;

import com.example.mercadolibremeli.model.entities.Productos;

import java.util.ArrayList;

public interface InterfacePresenter {

    void getProductCategorias(String id_pais, String id_categoria);

    void showProductCategorias(ArrayList<Productos> productos);

}
